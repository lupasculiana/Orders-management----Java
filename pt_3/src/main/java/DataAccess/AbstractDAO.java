package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectionFactory;

/**
 *
 * @param <T>
 * Apeluri directe catre baza de date - este o clasa generica si va fi folosita pentru a realiza si executa
 * query-uri
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /**
     * Va extrage numele clasei care o extinde si o apeleaza pentru a-l folosi in query-uri
     */
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     *
     * @param field
     * @return String
     * Realizeaza query-ul necesar pentru a selecta toate elementele din coloana data ca argument, din
     * tabelul necesar. ? este parametrul care va fi dat ulterior in functia care apeleaza query-ul
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    private String createUpdateQuery(String field1, String field2) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE  ");
        sb.append(type.getSimpleName());
        sb.append(" SET " + field1 + " =?");
        sb.append(" WHERE " + field2 + " =?");
        return sb.toString();
    }

    /**
     *
     * @param id
     * @param var
     * @return T
     * Realizeaza conexiunea cu baza de date, creeaza query-ul necesar in functie de ce tabel va folosi, si seteaza parametrul primit
     * ca argument (valoarea id-ului pe care o cauta). Extrage elementul din tabel in resultSet, si creeaza un obiect specific
     * acestuia cu informatiile din tabel
     */
    public T findById(int id, int var) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "";
        if(var == 1)
        {
            query = createSelectQuery("idclient");
        }
        else if(var == 2)
        {
            query = createSelectQuery("idproduct");
        }
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("nume");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public void update(int id, String field, String value, int var) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "";
        if(var == 1)
        {
            query = createUpdateQuery(field,"idclient");
        }
        else if(var == 2)
        {
            query = createUpdateQuery(field,"idproduct");
        }
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, value);
            statement.setString(2, String.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     *
     * @param resultSet
     * @return List<T>
     * Afla constructorii clasei necesare din pachetul Model si creeaza obiecte specifice folosind rezultatele
     * din baza de date, aflate in resultSet
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param list
     * @return JTable
     * Apeleaza anterior baza de date si extrage informatiile tuturor obiectelor dorite, si trimite lista ca parametru
     * functiei createTable. Aceasta o foloseste pentru a afla dimensiunea tabelului si pentru a initializa numele coloanelor,
     * urmand apoi sa populeze tabelul folosind un iterator si adaugand randuri in tabel. La final, returneaza un JTable care
     * va fi folosit ulterior
     */
    public static JTable createTable(ArrayList<?> list) {
        int tableSize = list.get(0).getClass().getDeclaredFields().length;
        String columnNames[] = new String[tableSize];
        int columnIndex = 0;
        for (java.lang.reflect.Field currentField : list.get(0).getClass().getDeclaredFields()) {
            currentField.setAccessible(true);
            try {
                columnNames[columnIndex] = currentField.getName();
                columnIndex++;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        for (Object ob : list) {
            Object[] obj = new Object[tableSize];
            int col = 0;
            for (java.lang.reflect.Field currentField : ob.getClass().getDeclaredFields()) {
                currentField.setAccessible(true);
                try {
                    obj[col] = currentField.get(ob);
                    col++;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            model.addRow(obj);
        }
        JTable table = new JTable(model);
        return table;
    }
}

package daos;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T extends DTO> {

    protected final Connection connection;

    public DAO(Connection conn){
        super();
        this.connection = conn;
    }

    public abstract T findById(int id);
    public abstract List<T> findAll();
    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(int id);
}

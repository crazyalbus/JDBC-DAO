package daos;

import models.Instrument;
import utils.DBUtil;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentsDAO extends DAO<Instrument> {

    private static final String INSERT = "Insert into instruments" +
            "(id, instrument, instrumentType, madeBy, yearMade, yearPurchased, owner)" +
            "values(?,?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM instruments WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM instruments";
    private static final String UPDATE = "UPDATE instruments SET instrument = ?, instrumentType = ?, madeBy = ?, yearMade = ?, " +
            "yearPurchased = ?, owner = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM instruments WHERE id = ?";



    public InstrumentsDAO(Connection conn) {
        super(conn);
    }

    public Instrument findById(int id) {
        Instrument instrument = null;
        try(PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(GET_ONE)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                instrument = new Instrument();
                instrument.setId(rs.getInt("id"));
                instrument.setInstrument(rs.getString("instrument"));
                instrument.setInstrumentType(rs.getString("instrumentType"));
                instrument.setMadeBy(rs.getString("madeBy"));
                instrument.setYearMade(rs.getInt("yearMade"));
                instrument.setYearPurchased(rs.getInt("yearPurchased"));
                instrument.setOwner(rs.getString("owner"));
            }
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return instrument;
    }

    public List<Instrument> findAll() {
        List<Instrument> listOfInstruments = new ArrayList<>();
        try(PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Instrument instrument = new Instrument();
                instrument.setId(rs.getInt("id"));
                instrument.setInstrument(rs.getString("instrument"));
                instrument.setInstrumentType(rs.getString("instrumentType"));
                instrument.setMadeBy(rs.getString("madeBy"));
                instrument.setYearMade(rs.getInt("yearMade"));
                instrument.setYearPurchased(rs.getInt("yearPurchased"));
                instrument.setOwner(rs.getString("owner"));
                listOfInstruments.add(instrument);
            }

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
        return listOfInstruments;
    }

    public Instrument update(Instrument dto) {
        Instrument instrument = null;
        try(PreparedStatement pstmt = this.connection.prepareStatement(UPDATE)){
            pstmt.setInt(7, dto.getId());
            pstmt.setString(1, dto.getInstrument());
            pstmt.setString(2, dto.getInstrumentType());
            pstmt.setString(3, dto.getMadeBy());
            pstmt.setInt(4, dto.getYearMade());
            pstmt.setInt(5, dto.getYearPurchased());
            pstmt.setString(6, dto.getOwner());
            pstmt.executeUpdate();
            instrument = this.findById(dto.getId());
        }catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return instrument;
    }

    public Instrument create(Instrument dto) {
        int key = -1;
        try(PreparedStatement pstmt = this.connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)){
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getInstrument());
            pstmt.setString(3, dto.getInstrumentType());
            pstmt.setString(4, dto.getMadeBy());
            pstmt.setInt(5, dto.getYearMade());
            pstmt.setInt(6, dto.getYearPurchased());
            pstmt.setString(7, dto.getOwner());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return this.findById(key);
    }

    public void delete(int id) {
        try(PreparedStatement pstmt = this.connection.prepareStatement(DELETE)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }
}

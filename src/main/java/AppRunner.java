import daos.InstrumentsDAO;
import models.Instrument;
import utils.DBUtil;

import java.sql.Connection;
import java.util.List;

public class AppRunner {
    public static void main(String args[]) {

        InstrumentsDAO run = new InstrumentsDAO(DBUtil.getConnection());

//        findById
//        System.out.println(run.findById(8).toString());

//        findAll()
//        List<Instrument> allInstruments= run.findAll();
//        for (Instrument i : allInstruments) {
//            System.out.println(i.toString());
//        }

//        update()
//        Instrument doug1 = run.findById(9);
//        doug1.setOwner("Doug");
//        Instrument updated = run.update(doug1);
//        System.out.println(updated.toString());

//        create()
//        Instrument kristof2 = new Instrument(10,"Violin", "Modern", "def violin co", 1921, 2001, "Kristof");
//        run.create(kristof2);

//        delete()
//        run.delete(9);
    }
}

package br.com.healthtrack.view;

import br.com.healthtrack.dao.BloodPressureDao;
import br.com.healthtrack.model.BloodPressure;

public class BloodPressureTest {
    public static void main(String[] args) {
        BloodPressureDao bloodPressureDao = new BloodPressureDao();

        BloodPressure bp1 = new BloodPressure(120, 80, "Normal", 3);
        BloodPressure bp2 = new BloodPressure(110, 70, "Normal", 3);
        BloodPressure bp3 = new BloodPressure(130, 80, "Elevada", 3);
        BloodPressure bp4 = new BloodPressure(110, 80, "Normal", 3);
        BloodPressure bp5 = new BloodPressure(120, 80, "Normal", 3);

        bloodPressureDao.create(bp1);
        bloodPressureDao.create(bp2);
        bloodPressureDao.create(bp3);
        bloodPressureDao.create(bp4);
        bloodPressureDao.create(bp5);

        for(BloodPressure bp: bloodPressureDao.getAll()){
            System.out.println(bp.toString());
        }
    }
}

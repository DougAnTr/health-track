package br.com.healthtrack;

import br.com.healthtrack.models.ActivityModel;
import br.com.healthtrack.models.PayingUserModel;
import br.com.healthtrack.models.UserModel;
import br.com.healthtrack.models.WeightModel;

public class App {
    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        PayingUserModel payingUserModel = new PayingUserModel();
        User user1 = new User(userModel, payingUserModel);
        PayingUser payingUser = new PayingUser(payingUserModel);
        WeightModel weightModel = new WeightModel();
        Weight weight1 = new Weight(user1, weightModel);
        ActivityModel activityModel = new ActivityModel();
        Activity activity1 = new Activity(user1, activityModel);

        User doug = user1.register("Douglas", "douglas.trofino@outlook.com", "12345678");
        User andreia = user1.register("andreia", "andreia", "12345678");


        System.out.println("Usuários: ");
        for(User u : userModel.list()){
            System.out.println("Nome: " + u.getName());
        }
        System.out.println();

        user1.signUp(andreia, "Básico");

        System.out.println("Usuários pagantes: ");
        for(User p : payingUserModel.list()){
            System.out.println("Nome: " + p.getName());
        }
        System.out.println();


        weight1.register(65, doug.getId());
        weight1.register(64, doug.getId());
        weight1.register(60, doug.getId());

        System.out.println("Dados do usuário " + doug.getName() + ": ");
        System.out.println();
        System.out.println("Pesos registrados");
        for (Weight w : weightModel.list()) {
            System.out.println(w.getDate() + ": " + w.getWeight() + "Kg");
        }

        activity1.register("Corrida", 1800000, doug.getId());
        activity1.register("Caminhada", 3600000, doug.getId());
        activity1.register("Corrida", 1800000, doug.getId());

        System.out.println();
        System.out.println("Atividades registradas");
        for(Activity activity : activity1.list()) {
            String duration = (activity.getTime() / 1000 / 60) + " minutos";

            System.out.println(activity.getDate() + " | " +activity.getDescription() + " -> " + duration);
        }
    }
}

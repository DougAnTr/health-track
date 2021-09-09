package br.com.healthtrack.activities;

import br.com.healthtrack.Activity;
import br.com.healthtrack.User;
import br.com.healthtrack.models.ActivityModel;

public class Running extends Activity {
    public Running(User user, ActivityModel activityModel) {
        super(user, activityModel);
    }

    public Running(int id, String description, long time, int userId) {
        super(id, description, time, userId);
    }
}

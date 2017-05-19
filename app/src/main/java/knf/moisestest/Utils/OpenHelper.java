package knf.moisestest.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import knf.moisestest.infoActivity;

/**
 * Created by Jordy on 19/05/2017.
 */

public class OpenHelper {
    public static void open(Activity activity, ContentFactory.Animal animal, View imageView, View textView) {
        Bundle bundle = new Bundle();
        bundle.putString("name", animal.name);
        bundle.putInt("img", animal.res_img);
        bundle.putInt("desc", animal.res_desc);
        Intent intent = new Intent(activity, infoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bundle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> img = Pair.create(imageView, imageView.getTransitionName());
            Pair<View, String> name = Pair.create(textView, textView.getTransitionName());
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, img, name);
            activity.startActivity(intent, optionsCompat.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }
}

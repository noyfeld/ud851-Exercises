package android.example.com.visualizerpreferences;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

public class FragmentPref extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.my_prefs);
    }
}

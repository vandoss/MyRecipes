package com.katran.myrecipes.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.katran.myrecipes.R

class MySettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}
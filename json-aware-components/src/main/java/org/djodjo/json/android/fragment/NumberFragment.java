/*
 * Copyright (C) 2014 Kalin Maldzhanski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.djodjo.json.android.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import org.djodjo.json.android.R;

import java.util.ArrayList;


public class NumberFragment extends BasePropertyFragment {

    public static final String ARG_MINIMUM = "minimum";
    public static final String ARG_MAXIMUM = "maximum";

    public final static int LAYOUT_NUMBER_TEXT = R.layout.fragment_number_text;
    public final static int LAYOUT_NUMBER_PICKER = R.layout.fragment_number_picker;

    private ArrayList<String> options;

    public NumberFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        int currDisplType = (displayType>=0)?displayType:displayTypes.get(ARG_GLOBAL_NUMBER_DISPLAY_TYPE);
        switch (currDisplType) {
            case DisplayType.DISPLAY_TYPE_TEXT: return LAYOUT_NUMBER_TEXT;
            case DisplayType.DISPLAY_TYPE_NUMBER_PICKER: return LAYOUT_NUMBER_PICKER;
        }
        return LAYOUT_NUMBER_TEXT;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        if(displayType == LAYOUT_NUMBER_TEXT) {
            TextView propValue = (TextView) v.findViewById(R.id.prop_value);
            propValue.setTextAppearance(getActivity(), styleValue);
        }

        return v;
    }
}
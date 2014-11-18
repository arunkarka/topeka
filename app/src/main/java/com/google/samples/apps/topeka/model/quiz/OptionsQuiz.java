/*
 * Copyright 2014 Google Inc.
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

package com.google.samples.apps.topeka.model.quiz;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;
import com.google.samples.apps.topeka.model.JsonAttributes;

import java.util.Arrays;

public abstract class OptionsQuiz<T> extends Quiz<int[]> {

    @SerializedName(JsonAttributes.OPTIONS)
    private T[] mOptions;

    public OptionsQuiz(String question, int[] answer, T[] options) {
        super(question, answer);
        mOptions = options;
    }

    public OptionsQuiz(Parcel in) {
        super(in);
        final int answer[] = in.createIntArray();
        setAnswer(answer);
    }

    public T[] getOptions() {
        return mOptions;
    }

    protected void setOptions(T[] options) {
        mOptions = options;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeIntArray(getAnswer());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OptionsQuiz)) {
            return false;
        }

        OptionsQuiz that = (OptionsQuiz) o;

        if (!Arrays.equals(getAnswer(), ((int[]) that.getAnswer()))) {
            return false;
        }
        if (!Arrays.equals(mOptions, that.mOptions)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(mOptions);
        return result;
    }
}

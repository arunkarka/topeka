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

import android.test.suitebuilder.annotation.SmallTest;

@SmallTest
public class AlphaPickerQuizTest extends AbsQuizTestCase<AlphaPickerQuiz> {

    private static final String ANSWER = "answer";

    @Override
    public void testGetAnswer() {
        assertEquals(ANSWER, getQuiz().getAnswer());
    }

    @Override
    public AlphaPickerQuiz getQuiz() {
        return new AlphaPickerQuiz(QUESTION, ANSWER);
    }

    @Override
    public QuizType getExpectedQuizType() {
        return QuizType.ALPHA_PICKER;
    }

}
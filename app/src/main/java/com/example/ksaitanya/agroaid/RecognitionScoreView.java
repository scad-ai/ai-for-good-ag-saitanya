/* Copyright 2015 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.ksaitanya.agroaid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.example.ksaitanya.agroaid.Classifier.Recognition;
import java.util.List;

public class RecognitionScoreView extends View implements ResultsView {
  private static final float TEXT_SIZE_DIP = 24;
  private List<Recognition> results;
  private final float textSizePx;
  private final Paint fgPaint;
  private final Paint bgPaint;
    static String a=null;
  public RecognitionScoreView(final Context context, final AttributeSet set) {
    super(context, set);

    textSizePx =
            TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
    fgPaint = new Paint();
    fgPaint.setTextSize(textSizePx);

    bgPaint = new Paint();
    bgPaint.setColor(0xccd2dce5); //set color for results BG
  }

  @Override
  public void setResults(final List<Recognition> results) {
    this.results = results;
    postInvalidate();
  }

  @Override
  public void onDraw(final Canvas canvas) {
    final int x = 10;
    int y = (int) (fgPaint.getTextSize() * 1.25f);
    canvas.drawPaint(bgPaint);
    if (results != null) {
      float i=0;
        a=null;
      for (final Recognition recog : results) {
        if (recog.getConfidence() > i) {
          i = recog.getConfidence();
          a = recog.getTitle();
        }
      }
      if(i>0.6) {
            canvas.drawText("Result: "+a, x, y, fgPaint);
      }
      else {
          canvas.drawText("Sorry! Cannot Recognise", x, y, fgPaint);
      }
    }
  }
}

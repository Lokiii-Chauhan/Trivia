package com.lokiiichauhan.trivia.data;

import android.util.Log;

import com.android.volley.toolbox.JsonArrayRequest;
import com.lokiiichauhan.trivia.controller.AppController;
import com.lokiiichauhan.trivia.model.Question;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    ArrayList<Question> questionArrayList = new ArrayList<>();
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestion(final AnswerListAsyncResponse callBack) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, response -> {

            for (int i = 0; i < response.length(); i++) {
                try {
                    Question question =
                            new Question(response.getJSONArray(i)
                                    .getString(0), response.
                                    getJSONArray(i).getBoolean(1));

                    questionArrayList.add(question);
                    Log.d("JSON", questionArrayList+ "");


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (null != callBack) {
                    callBack.processfinished(questionArrayList);
                }
            }

        }, error -> {

        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}


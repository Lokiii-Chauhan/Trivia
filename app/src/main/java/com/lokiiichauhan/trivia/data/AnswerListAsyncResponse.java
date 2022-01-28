package com.lokiiichauhan.trivia.data;

import com.lokiiichauhan.trivia.model.Question;

import java.util.ArrayList;
import java.util.Queue;

public interface AnswerListAsyncResponse {

    void processfinished(ArrayList<Question> questionArrayList);

}

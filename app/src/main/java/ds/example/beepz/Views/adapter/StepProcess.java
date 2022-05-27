package ds.example.beepz.Views.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ds.example.beepz.R;
import ds.example.beepz.verticalstepperform.Step;

public class StepProcess extends Step<String> {
    private String name;
    private int pos;
    private int[] icons = {

    };

    public StepProcess(String stepTitle, int pos) {
        super(stepTitle);
        this.name = stepTitle;
        this.pos = pos;
    }

    @Override
    protected View createStepContentLayout() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.step_item, null, false);
        TextView text = view.findViewById(R.id.process_title);
        text.setText(name);
        return view;
    }


    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        return new IsDataValid(true, "3 characters minimum");
    }

    @Override
    public String getStepData() {
        return "";
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return "you are putting that monkey in the";
    }

    @Override
    protected void onStepOpened(boolean animated) {
        // This will be called automatically whenever the step gets opened.
    }

    @Override
    protected void onStepClosed(boolean animated) {
        // This will be called automatically whenever the step gets closed.
    }


    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {
        // This will be called automatically whenever the step is marked as completed.
    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {
        // This will be called automatically whenever the step is marked as uncompleted.
    }

    @Override
    protected void restoreStepData(String stepData) {

    }
}

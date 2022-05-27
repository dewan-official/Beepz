package ds.example.beepz.Views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ds.example.beepz.R;
import ds.example.beepz.Views.adapter.StepProcess;
import ds.example.beepz.verticalstepperform.Step;
import ds.example.beepz.verticalstepperform.VerticalStepperFormView;
import ds.example.beepz.verticalstepperform.listener.StepperFormListener;

public class ServiceActivity extends AppCompatActivity implements StepperFormListener {

    private StepProcess step1, step2, step3, step4, step5, step6, step7, step8, step9;

    private ImageView back;
    private TextView orderID;

    private VerticalStepperFormView verticalStepperForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        back = findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        orderID = findViewById(R.id.order_id);

        orderID.setText(getIntent() == null ? "" : "#"+getIntent().getIntExtra("order_id", 0));

        // Create the steps.
        step1 = new StepProcess("Booking Confirmed", 0);
        step2 = new StepProcess("Driver on the way to pickup", 1);
        step3 = new StepProcess("QR Code Scaned", 2);
        step4 = new StepProcess("Car Picked Up", 3);
        step5 = new StepProcess("Reached Garage", 4);
        step6 = new StepProcess("Service Started", 5);
        step7 = new StepProcess("Service Ended", 6);
        step8 = new StepProcess("Driver on the way to Drop Off", 7);
        step9 = new StepProcess("Booking Completed", 8);

        verticalStepperForm = findViewById(R.id.stepper_form);
        verticalStepperForm
                .setup(this, step1, step2, step3, step4, step5, step6, step7, step8, step9)
                .allowNonLinearNavigation(true)
                .allowStepOpeningOnHeaderClick(false)
                .closeLastStepOnCompletion(true)
                .init();

        int pos = (getIntent() == null) ? 0 : getIntent().getIntExtra("position", 1)-1;

        for (int i=0; i<pos; i++){
            verticalStepperForm.markStepAsCompleted(i, true);
        }
        verticalStepperForm.goToStep(pos, true);
        verticalStepperForm.refreshFormProgress();

    }

    @Override
    public void onCompletedForm() {}

    @Override
    public void onCancelledForm() {}

    @Override
    public void onStepAdded(int index, Step<?> addedStep) {}

    @Override
    public void onStepRemoved(int index) {}
}
package com.example.android.leaderboard;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.leaderboard.Network.RetrofitPostingClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ProjectSubmission extends AppCompatActivity {
    EditText FirstName;
    EditText LastName;
    EditText EmailAddress;
    EditText ProjectLink;
    TextView Results;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        FirstName = findViewById(R.id.first_name);

        LastName = findViewById(R.id.Last_name);

        EmailAddress = findViewById(R.id.submit_email);

        ProjectLink = findViewById(R.id.editTextProjectLink);

        Results = findViewById(R.id.textViewResults);






        final SendDataService service = RetrofitPostingClientInstance.getRetrofitInstance().create(SendDataService.class);



        Button submitProjectBtn = findViewById(R.id.Submit_Project_button);

        submitProjectBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {



                mProgressDialog = new ProgressDialog(ProjectSubmission.this);

                mProgressDialog.setMessage("Loading....");

                mProgressDialog.show();



                String name = FirstName.getText().toString();

                String lastName = LastName.getText().toString();

                String emailAddress = EmailAddress.getText().toString();

                String projectLink = ProjectLink.getText().toString();





                service.submitProject(name, lastName, emailAddress, projectLink).enqueue(new Callback<ResponseBody>() {

                    @Override

                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        mProgressDialog.dismiss();

                        String results = "Project submitted to API." + " Was it successful? " + response.isSuccessful()

                                + ". Status Code " + response.code()

                                + ". Message " + response.message();

                        Results.setText(results);


                    }


                    @Override

                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        mProgressDialog.dismiss();

                        Toast.makeText(ProjectSubmission.this, "Unable to submit post to API.", Toast.LENGTH_LONG).show();

                    }

                });

            }

        });
    }
}
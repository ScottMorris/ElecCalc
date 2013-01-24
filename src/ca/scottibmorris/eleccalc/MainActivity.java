package ca.scottibmorris.eleccalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleccalc_activity_main);

		Spinner formulaChoice = (Spinner) findViewById(R.id.formulaSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.formula_options,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		formulaChoice.setAdapter(adapter);

		final EditText resultText = (EditText) findViewById(R.id.equationResultText);
		final EditText operand1 = (EditText) findViewById(R.id.equationOperand1Text);
		final EditText operand2 = (EditText) findViewById(R.id.equationOperand2Text);
		Button calculateButton = (Button) findViewById(R.id.calulateButton);

		calculateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (resultText.getText().length() == 0) {
					double operand1Value = Double.valueOf(operand1.getText()
							.toString());
					double operand2Value = Double.valueOf(operand2.getText()
							.toString());

					double result = operand1Value * operand2Value;
					resultText.setText(String.valueOf(result));
				} else if (operand1.getText().length() == 0) {
					double result = Double.valueOf(resultText.getText()
							.toString());
					double operand2Value = Double.valueOf(operand2.getText()
							.toString());

					double operand1Value = result / operand2Value;
					operand1.setText(String.valueOf(operand1Value));
				} else if (operand2.getText().length() == 0) {
					double result = Double.valueOf(resultText.getText()
							.toString());
					double operand1Value = Double.valueOf(operand1.getText()
							.toString());

					double operand2Value = result / operand1Value;
					operand2.setText(String.valueOf(operand2Value));

				} else {
					// error handling code
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}

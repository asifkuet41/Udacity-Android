package com.example.android.coffeeorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decreaseQuantity(View view){
        if(quantity == 1){
            Toast.makeText(this,"You can't have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity-=1;
        displayQuantity(quantity);
    }

    public void increaseQuantity(View view){
        if(quantity == 100){
            Toast.makeText(this,"You can't have more than 100 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity+=1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view){
        EditText nameField = findViewById(R.id.nameField);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);

        String priceMessage = createOrderSummary(name,price,hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate){
        int basePrice = 5;

        if(hasWhippedCream){
            basePrice +=1;
        }

        if(hasChocolate){
            basePrice +=2;
        }
        return quantity*basePrice;
    }

    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = findViewById(R.id.quantity);
        quantityTextView.setText(""+numberOfCoffees);
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = name;
        priceMessage +="\nAdd Whipped Cream? "+addWhippedCream;
        priceMessage +="\nAdd chocolate? "+addChocolate;
        priceMessage +="\nQuantity: "+quantity+"\nTotal: $"+price;
        priceMessage += "\n"+getString(R.string.thank_you);
        return priceMessage;
    }


}

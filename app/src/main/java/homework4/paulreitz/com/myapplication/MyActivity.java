package homework4.paulreitz.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final MySQLiteHelper db = new MySQLiteHelper(this);

        String[] country={"Options","Add Book","Remove Book", "Get All Books"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

        /**
         * CRUD Operations
         * */
        // add Books

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                    {
                        //when an item is selected
                        if (parent.getSelectedItem().toString().contains("Add Book"))
                        {
                            AlertDialog.Builder alert = new AlertDialog.Builder(MyActivity.this);

                            alert.setTitle("Book Addition Database");
                           // alert.setMessage("Enter book name!");

// Set an EditText view to get user input

                            LinearLayout lila1= new LinearLayout(MyActivity.this);
                            lila1.setOrientation(LinearLayout.VERTICAL);
                            final EditText input = new EditText(MyActivity.this);
                            final EditText input1 = new EditText(MyActivity.this);
                            input.setHint("Enter Book Name");
                            input1.setHint("Enter Author");
                            lila1.addView(input);
                            lila1.addView(input1);
                            alert.setView(lila1);

                            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    String value = input.getText().toString();
                                    // Do something with value!
                                    db.addBook(new Book(input.getText().toString(), input1.getText().toString()));
                                }
                            });

                            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // Canceled.
                                }
                            });

                            alert.show();
                        }
                        else if(parent.getSelectedItem().toString().contains("Remove Book"))
                        {
                            System.out.println("Remove Book selected");
                            AlertDialog.Builder alert = new AlertDialog.Builder(MyActivity.this);
                            alert.setTitle("Book Removal Database");
                            // alert.setMessage("Enter book name!");

// Set an EditText view to get user input

                            LinearLayout lila1= new LinearLayout(MyActivity.this);
                            lila1.setOrientation(LinearLayout.VERTICAL);
                            final EditText input = new EditText(MyActivity.this);
                            final EditText input1 = new EditText(MyActivity.this);
                            input.setHint("Enter Book Name");
                            input1.setHint("Enter Author");
                            lila1.addView(input);
                            lila1.addView(input1);
                            alert.setView(lila1);

                            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    String value = input.getText().toString();
                                    // Do something with value!
                                    List<Book> list = db.getAllBooks();
                                    String author = input1.getText().toString();
                                    String name = input.getText().toString();
                                    for(Book book : list)
                                    {

                                        if (book.getAuthor()== author && book.getTitle() == name)
                                        {
                                            db.deleteBook(book);

                                        }

                                    }

                                    // delete one book



                                }
                            });

                            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // Canceled.
                                }
                            });

                            alert.show();


                        }
                        else if(parent.getSelectedItem().toString().contains("Get All Books"))
                        {
                            //show all the books
                            int start = 0;
                            int maxsize = db.getAllBooks().size();
                            String[] toppings = new String[maxsize];
                            List<Book> list = db.getAllBooks();

                            for(Book book : list)
                            {

                                String name = book.getTitle();
                                String author = book.getAuthor();
                                toppings[start] = name;
                                start++;

                            }
                            String[] country= toppings;
                            ArrayAdapter<String> stringArrayAdapter=
                                    new ArrayAdapter<String>(
                                            MyActivity.this,
                                            android.R.layout.simple_spinner_dropdown_item,
                                            country);



                            AlertDialog.Builder alert = new AlertDialog.Builder(MyActivity.this);
                            LinearLayout lila1= new LinearLayout(MyActivity.this);
                            lila1.setOrientation(LinearLayout.VERTICAL);
                            final Spinner spinnerlist = new Spinner(MyActivity.this);
                            spinnerlist.setAdapter(stringArrayAdapter);
                            lila1.addView(spinnerlist);
                            alert.setView(lila1);

                            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {



                                    // delete one book



                                }
                            });

                            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // Canceled.
                                }
                            });

                            alert.show();










                        }
                    }
                        @Override
                        public void onNothingSelected( AdapterView<?>  parent)
                        {
                            //when nothing is selected
                            return;


                        }
                    };

        spinner.setOnItemSelectedListener(onSpinner);


        //db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
        //db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));
        //db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));

        // get all books
        //List<Book> list = db.getAllBooks();

        // delete one book
        //db.deleteBook(list.get(0));

        // get all books
        //db.getAllBooks();

    }

}

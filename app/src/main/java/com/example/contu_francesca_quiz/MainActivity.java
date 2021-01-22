package com.example.contu_francesca_quiz;

import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    //set controls
    TextView ContatoreDomande, Timer, Dom;

    Button btOpt1, btOpt2, btOpt3, btOpt4;

    int punteggio=0;
    static String s = " ";

    //list for que
    ArrayList<Domande> ListaDomande = new ArrayList<>();

    int contatore = 0;

    CountDownTimer tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find view by ids
        Dom = findViewById(R.id.Dom);
        ContatoreDomande = findViewById(R.id.ContatoreDomande);
        Timer = findViewById(R.id.Timer);

        btOpt1 = findViewById(R.id.btOpt1);
        btOpt2 = findViewById(R.id.btOpt2);
        btOpt3 = findViewById(R.id.btOpt3);
        btOpt4 = findViewById(R.id.btOpt4);

        //lista
        ListaDomande.add(new Domande("Quale tra queste regioni non confina con la Liguria?", "Piemonte", "Lombardia",
                "Emilia Romagna", "Toscana", "Lombardia"));
        ListaDomande.add(new Domande("Dove si trova Assisi?", "Toscana", "Lazio",
                "Puglia", "Umbria", "Umbria"));
        ListaDomande.add(new Domande("Quale di queste regioni è bagnata dal Mar Tirreno?", "Emilia Romagna", "Abruzzo",
                "Basilicata", "Marche", "Basilicata"));
        ListaDomande.add(new Domande("Qual è il secondo fiume più lungo d'Italia?", "Adige", "Po",
                "Tevere", "Arno", "Adige"));
        ListaDomande.add(new Domande("Quale regione ha il territorio meno esteso?", "Molise", "Liguria",
                "Valle d'Aosta", "Basilicata", "Valle d'Aosta"));
        ListaDomande.add(new Domande("Quale paese è noto per i Trulli?", "Palermo", "Mantova",
                "Foggia", "Alberobello", "Alberobello"));
        ListaDomande.add(new Domande("Qual è il capoluogo della regione Calabria'", "Palermo", "Reggio Calabria",
                "Catanzaro", "Siracusa", "Catanzaro"));
        ListaDomande.add(new Domande("Quante province ha la Sicilia?", "tre", "cinque",
                "sette", "nove", "nove"));
        ListaDomande.add(new Domande("Qual è il monte più alto degli Appennini?", "La Maiella", "Gran Sasso",
                "Monte Rosa", "Monte Vettore", "Gran Sasso"));
        ListaDomande.add(new Domande("Quale di queste non fa parte delle regioni tra cui è situato il lago di Garda?", "Trentino-Alto Adige", "Friuli-Venezia Giulia",
                "Lombardia", "Veneto", "Friuli-Venezia Giulia"));
        //init cont
        contatore = 0;

        caricaDomande(contatore);
        Timer.setText("35");
        //countdown time
        tm = new CountDownTimer(35 * 1000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                Timer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Tempo scaduto", Toast.LENGTH_SHORT).show();
            }

        };
    }

    public void caricaDomande (int n) {

        final Domande d = ListaDomande.get(n);

        ContatoreDomande.setText((n + 1) + "/" + ListaDomande.size());

        Timer.setText("" + 35);
        if (tm != null) {
            tm.start();
        }
        Dom.setText("#" + (n + 1) + " " + d.getQue());
        btOpt1.setText("" + d.getOpt1());
        btOpt2.setText("" + d.getOpt2());
        btOpt3.setText("" + d.getOpt3());
        btOpt4.setText("" + d.getOpt4());

        btOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt1.getText().equals(d.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "E' la risposta corretta!", Toast.LENGTH_SHORT).show();
                    punteggio++;
                    if (contatore < (ListaDomande.size() - 1)) {
                        tm.cancel();
                        contatore++;
                        caricaDomande(contatore);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "La risposta è sbagliata", Toast.LENGTH_SHORT).show();
                    tm.cancel();
                    contatore++;
                    caricaDomande(contatore);
                }


                if (contatore == (ListaDomande.size() - 1)) {
                    Toast.makeText(MainActivity.this, "Tutte le domande sono state completate! Fare clic sulla risposta scelta per continuare", Toast.LENGTH_LONG).show();
                    btOpt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Dialog1();
                        }
                    });
                }
            }
        });


        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt2.getText().equals(d.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "E' la risposta corretta!", Toast.LENGTH_SHORT).show();
                    punteggio++;
                    if (contatore < (ListaDomande.size() - 1)) {
                        tm.cancel();
                        contatore++;
                        caricaDomande(contatore);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "La risposta è sbagliata", Toast.LENGTH_SHORT).show();
                    tm.cancel();
                    contatore++;
                    caricaDomande(contatore);

                }
                if (contatore == (ListaDomande.size() - 1)) {
                    Toast.makeText(MainActivity.this, "Tutte le domande sono state completate! Fare clic sulla risposta scelta per continuare", Toast.LENGTH_LONG).show();
                    btOpt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Dialog1();
                        }
                    });
                }
            }
        });

        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt3.getText().equals(d.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "E' la risposta corretta!", Toast.LENGTH_SHORT).show();
                    punteggio++;
                    if (contatore < (ListaDomande.size() - 1)) {
                        tm.cancel();
                        contatore++;
                        caricaDomande(contatore);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "La risposta è sbagliata", Toast.LENGTH_SHORT).show();
                    tm.cancel();
                    contatore++;
                    caricaDomande(contatore);
                }


                if (contatore == (ListaDomande.size() - 1)) {
                    Toast.makeText(MainActivity.this, "Tutte le domande sono state completate! Fare clic sulla risposta scelta per continuare", Toast.LENGTH_LONG).show();
                    btOpt3.setOnClickListener(view -> Dialog1());
                }
            }
        });



        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt4.getText().equals(d.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "E' la risposta corretta!", Toast.LENGTH_SHORT).show();
                    punteggio++;
                    if (contatore < (ListaDomande.size() - 1)) {
                        tm.cancel();
                        contatore++;
                        caricaDomande(contatore);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "La risposta è sbagliata", Toast.LENGTH_SHORT).show();
                    tm.cancel();
                    contatore++;
                    caricaDomande(contatore);
                }


                if (contatore == (ListaDomande.size() - 1)) {
                    Toast.makeText(MainActivity.this, "Tutte le domande sono state completate! Fare clic sulla risposta scelta per continuare", Toast.LENGTH_LONG).show();
                    btOpt4.setOnClickListener(view -> Dialog1());
                }
            }
        });
    }
    public String getPunteggio () {
        s = Integer.toString(punteggio);
        return s;
    }

    public void Dialog1 () {

        Dialog1 exampleDialog = new Dialog1();
        exampleDialog.show(getSupportFragmentManager(), "dialog");
        Toast.makeText(this, "Hai ottenuto " + punteggio + " punti", Toast.LENGTH_LONG).show();
    }
}














































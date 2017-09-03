package com.training.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_country);
        CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), mImageId, mCountryId);
        listView.setAdapter(countryAdapter);
    }

    int mImageId[] = {
            R.drawable.a001_algeria, R.drawable.a002_austria,
            R.drawable.a003_bhutan, R.drawable.a004_burkina_faso,
            R.drawable.a005_china, R.drawable.a006_cyprus,
            R.drawable.a007_czech, R.drawable.a008_france,
            R.drawable.a009_georgia, R.drawable.a010_japan,
            R.drawable.a011_kenya, R.drawable.a012_lesotho,
            R.drawable.a013_madagascar, R.drawable.a014_malawi,
            R.drawable.a015_malta, R.drawable.a016_mauritania,
            R.drawable.a017_morocco, R.drawable.a018_mozambique,
            R.drawable.a019_namibia, R.drawable.a020_netherlands,
            R.drawable.a021_pakistan, R.drawable.a022_peru,
            R.drawable.a023_russia, R.drawable.a024_senegal,
            R.drawable.a025_slovakia, R.drawable.a026_somalia,
            R.drawable.a027_south_africa, R.drawable.a028_south_korea,
            R.drawable.a029_suriname, R.drawable.a030_syria,
            R.drawable.a031_tanzania, R.drawable.a032_thailand,
            R.drawable.a033_turkmenistan, R.drawable.a034_uganda,
            R.drawable.a035_uruguay, R.drawable.a036_venezuela,
            R.drawable.a037_vietnam
    };

    String mCountryId[] = {
            "Algeria", "Austria",
            "Bhutan", "Bukina Faso",
            "China", "Cyprus",
            "Czech", "France",
            "Georgia", "Japan",
            "Kenya", "Lesotho",
            "Madagascar", "Malawi",
            "Malta", "Mauritania",
            "Morocco", "Mozambique",
            "Namibia", "Netherlands",
            "Pakistan", "Peru",
            "Russia", "Senegal",
            "Slovakia", "Somalia",
            "South Africa", "South Korea",
            "Suriname", "Syria",
            "Tanzania", "Thailand",
            "Turkmenistan", "Uganda",
            "Uruguay", "Venezuela",
            "Vietnam"
    };
}

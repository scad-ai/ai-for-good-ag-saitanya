package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class More extends Activity {
TextView details;
    Button b,call1,call2,call3,msg1,msg2,msg3;
    RelativeLayout expert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        details = (TextView) findViewById(R.id.details);
        b = (Button) findViewById(R.id.back);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), ClassifierActivity.class);
                startActivity(intent);
            }
        });
        fillDetails();
        contactExperts();
    }
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(More.this, ClassifierActivity.class);
        startActivity(intent);
    }

    public void contactExperts(){
        call1 = (Button) findViewById(R.id.call1);
        call2 = (Button) findViewById(R.id.call2);
        call3 = (Button) findViewById(R.id.call3);
        msg1 = (Button) findViewById(R.id.msg1);
        msg2 = (Button) findViewById(R.id.msg2);
        msg3 = (Button) findViewById(R.id.msg3);

        call1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        call2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        call3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        msg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Agro Aid detected "+RecognitionScoreView.a+" in my plant. I request call back for expert advice");
                startActivity(smsIntent);
            }
        });
        msg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Agro Aid detected "+RecognitionScoreView.a+" in my plant. I request call back for expert advice");
                startActivity(smsIntent);
            }
        });
        msg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Agro Aid detected "+RecognitionScoreView.a+" in my plant. I request call back for expert advice");
                startActivity(smsIntent);
            }
        });
    }
    public void fillDetails(){
        expert =(RelativeLayout)findViewById(R.id.expert);

        if(RecognitionScoreView.a.equals("Coffee Plant")) {
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Coffee plant. Coffee are flowering plants whose seeds (coffee beans), used in making various coffee beverages and products. They are shrubs  native to tropical and southern Africa and tropical Asia. Here are some fun facts about coffee.\n" +
                    "Shepherds discovered coffee in Ethiopia circa 800 A.D.\n" +
                    "The majority of coffee is produced in Brazil.\n" +
                    "Hawaii is the only state in the U.S. that commercially grows coffee.\n" +
                    "Coffee was originally a food. Coffee berries were mixed with fat to create an energy-rich snack ball.\n" +
                    "The world's most expensive coffee is Rs. 39,065 half a kG.\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Daisy Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Daisy plant. Here are a few fun facts about Daisy.\n" +
                    "Daisies belong to one of the largest families of plants in the world making up almost 10% of all flowering plants on Earth.\n" +
                    "Daisies are found everywhere on Earth except Antarctica.\n" +
                    "A daisy is actually two flowers in one, the white petals and the cluter of tiny yello disc petals.\n" +
                    "Daisies are thought to slow bleeding, relieve indigestion and ease coughs.\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Rice Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Rice plant. Go to Guide to learn how to plant rice and also know the nutrition content in rice. Meanwhile, here are a few fun facts about rice.\n" +
                    "Rice is the oldest known food that is still widely consumed today. Archaeologists can date its consumption back to 5000 BC.\n" +
                    "There are over 40,000 varieties of rice including Basmati, Thai Jasmine and Italian Arborio.\n" +
                    "Asia alone both produces and consumes 90% of the world’s rice.\n" +
                    "In Bali, Indonesia, Hindus believe that it was Vishnu who first made rice grow out of the ground from nothing. \n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Rose Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Rose plant. Go to Guide to learn how to plant rose. Meanwhile, here are a few fun facts.\n" +
                    "In nature, the genus Rosa has some 150 species spread throughout the Northern Hemisphere, from Holland to Mexico and North Africa.\n" +
                    "Although roses can come in a wide variety of colours, a ‘black rose’ is not actually black but a very dark red.\n" +
                    "Roses can grow quite tall. The tallest ever recorded rose bush stands at over 23 feet (7 metres) tall.\n" +
                    "The buds of the tiniest roses are the size of a grain of rice.\n" +
                    "\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Sugarcane Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Sugarcane plant. Sugarcane are several species of tall perennial true grasses and are a source of sugar in all tropical and subtropical countries of the world. Here are a few fun facts.\n" +
                    "Sugarcane was the world’s largest crop by production quantity in 2012.\n" +
                    "Brazil is the largest producer of sugar cane in the world.\n" +
                    "Sugarcane plants takes 9 to 24 months to grow to maturity, depending on the climate.\n" +
                    "The majority of a sugarcane stalk is made of water, with up to three quarters possible, while up to 16% can be sugar, and the fibre content can be also be up to 16%.\n" +
                    "The fibres of the sugarcane plant can be woven into mats; used for papermaking purposes; and added to other fibres to make fabric.";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Sunflower Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Sunflower plant. Sunflower is a plant with the flower fellow in color and it tracks the sun througout the day. Here are a few fun facts about sunflowers.\n" +
                    "They are native to Americas.\n" +
                    "The world's tallest sunflower reaches 30 feet and 1 inch.\n" +
                    "In 2012, U.S. astronaut Don Pettit brought along a few companions to the International Space Station: sunflower seeds. \n" +
                    "Each sunflower's head is made of thousands smaller flowers.\n" +
                    "Once the flower heads are empty of seeds, they can be converting into disposable scrubbing pads";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Tea Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Tea plant. Tea plants also known as Camellia sinensis is a species of evergreen shrub whose leaves and leaf buds are used to produce tea. Here are a few fun facts about tea.\n" +
                    "It contains “polyphenols”—antioxidants that repair cells and help our bodies fight cardiovascular diseases, cancers, osteoporosis, diabetes mellitus and other maladies.\n" +
                    "It takes around 2,000 tiny leaves to make just one pound of finished tea.\n" +
                    "Tea didn’t reach most Europeans until the late 16th century.\n" +
                    "Genuine “Darjeeling” tea is grown in an area of India at the foot of the Himalayas that’s less than 70 square miles large.";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Wheat Plant")){
            expert.setVisibility(View.GONE);
            String message = "Agro aid has detected a healthy Wheat plant. Wheat is a member of the grass family widely cultivated for its seed, a cereal grain which is a worldwide staple food. Here are a few fun facts.\n" +
                    "About 95% of the wheat produced is common wheat also known as bread wheat.\n" +
                    "Wheat is grown to some extent on every continent except Antarctica.\n" +
                    "Wheat is grown on more land area than any other food crop.\n" +
                    "The archaeological record suggests that wheat was first cultivated around 9600 BC.\n" +
                    "World trade in wheat is greater than for all other crops combined.\n" +
                    "Wheat is the leading source of vegetable protein in human food.\n" +
                    "Botanically, the wheat kernel is a type of fruit called a caryopsis.\n" +
                    "All types of wheat can be divided in two major groups: spring and winter wheat. Spring wheat is planted during the spring and harvested during the summer. Winter wheat is planted at autumn and harvested during the spring.";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Bacterial Blight Disease")) {
            String message = "Agro aid has detected that your plant has Bacterial Blight disease. Below are few tips to treat the disease.\n" +
                    "1. Remove all the affected parts of the plant using a clear shear or pruner. It is important to disinfect the tool for every cut using 1:4 bleach to water solution.\n" +
                    "2.Dispose the debris immediately so that the soil won't be infected and add a layer of organic compost.\n" +
                    "3. Apply copper-based fungicides when disease first appears, and repeat every 7-10 days for as long as needed. Cover both the tops and undersides of leaves with a thin uniform film.";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Blackspots Disease")) {
            String message = "Agro aid has detected that your plant has Blackspots disease. Below are few tips to treat the disease.\n" +
                    "1. Prune (remove) the infected leaves including those that are turning yellow immediately and prevent any contact of these leaves with the remaining plant or soil.\n" +
                    "2. Disinfect the pruming tool each time you remove a leaf using 1:4 bleach to water solution.\n" +
                    "3. Use any other following methods to prevent the disease from spreading to the remaining plant.\n" +
                    "-> Make a solution by mixing dairy milk and water in the ratio 1:2 and spray the leaves with a solution once each week. \n" +
                    "-> Once every two weeks, spray the leaves with neem oil.\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Powdery Mildew Disease")) {
            String message = "Agro aid has detected that your plant has Powdery Mildew disease. Below are few tips to treat the disease.\n" +
                    "1. There are different homemade sprays that can help treat powdery mildew.\n" +
                    "Spray 1: Using 1 cup cow's milk, 3 cups water, Pinch of bicarbonate of soda (baking soda). This spray is suitable for spraying on roses and squash leaves.\n" +
                    "Spray 2: Using 3/4 teaspoon baking soda, 3/4 teaspoon soap (non-detergent, thick consistency), 2 cups water, 2 cups watery cow's milk.\n" +
                    "Spray 3: Using 1 ounce cow's milk, 9 ounces water.\n" +
                    "2. Mix together the ingredients in a large bowl. \n" +
                    "3. Pour the mixture into a spray bottle.\n" +
                    "4. Shake before use. Spray on the plants to remove the mildew. \n" +
                    "5. Spray 2-3 times a week for better results.\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Aphids Pest")) {
            String message = "Agro aid has detected that your plant has Aphids pest attack. Below are few tips to treat the pest.\n" +
                    "1. Pick them off the plant or wipe them off with a cloth.\n" +
                    "2. Cut out the whole damaged part of the plant, destroying the whole colony of aphids.\n" +
                    "3. Hose the plants with cold water, making sure you reach the leaf undersides. Concentrate on younger plants, which aphids prefer. Do this every couple of days.\n" +
                    "4. Make a solution using 8 cups of warm water, 1/2 cup of, vegetable oil, 6-8 drops of dish soap (Do not use too much soap, as it can burn the leaves), a pinch of cayenne pepper. Spray infected plants when the sun isn’t strong, and when it is not going to rain. \n" +
                    "Shake well and use this weekly on infected plants.\n" +
                    "5. Plant ginger, which has a strong smell that aphids hate, and is a useful deterrent. ";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Brown Wheat-mite Pest")) {
            String message = "Agro aid has detected that your plant has Brown Wheat-mite pest attack. Below are few tips to treat the pest.\n" +
                    "1. Pick them off the plant or wipe them off with a cloth.\n" +
                    "2. Cut out the whole damaged part of the plant, destroying the whole colony of aphids.\n" +
                    "3. Hose the plants with cold water, making sure you reach the leaf undersides.\n" +
                    "4. Make a solution using 8 cups of warm water, 1/2 cup of, vegetable oil, 6-8 drops of dish soap (Do not use too much soap, as it can burn the leaves), a pinch of cayenne pepper. Spray infected plants when the sun isn’t strong, and when it is not going to rain. \n" +
                    "Shake well and use this weekly on infected plants.\n" +
                    "5. The mites can also be controlled by the spray of Thiometon or Dimethoate, that can be bought from market. \n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Caseworm Pest")) {
            String message = "Agro aid has detected that your plant has Caseworm pest attack. Below are few tips to treat the pest.\n" +
                    "1. Using a vacuum cleaner, suck the pests from the undersides of the leaves of the infested plants.\n" +
                    "2. Remove the severely diseased leaves and branches using garden clippers. Make sure to properly dispose of the diseased leaves.\n" +
                    "3. Put one good squirt of dish soap into 1 gallon (3.8 L) of water and mix well. Use this solution to wash the plant, every 3 or 4 days.\n" +
                    "4. Trap the pest by placing a sticky yellow pad close to the leaves. Take down the traps once the population is mostly dead, and you only find a few flies caught each day. \n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Spider-mite Pest")) {
            String message = "Agro aid has detected that your plant has Spider-mite pest attack. Below are few tips to treat the pest.\n" +
                    "1. Isolate the plant immediately.\n" +
                    "2. Begin pruning the plant, removing any stems, leaves, or other infested parts of the plant and throw in the trash.\n" +
                    "3. Using a high pressure water hose or nozzle, spray plant.\n" +
                    "4. Create a soap spray by combining two tablespoons of gentle soap, one to two tablespoons of cooking oil, and a gallon of water. Spray plants thoroughly, repeating every four to seven days until spider mites appear gone. \n" +
                    "5. Make pepper spray by combining one teaspoon pepper or hot sauce, one quart of warm water, and a few drops of liquid dish detergent. Let the solution sit overnight. Spray on the bottom of leaves, keeping it away from your face, and shaking frequently to prevent ingredients from settling.\n" +
                    "6. You can also use oil solutions like neem oil, Eucalyptus oil, Lemon oil, Cinnamon oil by mixing 10 millimeters of oil in 1 liter lukewarm water.";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Nitrogen Deficiency")) {
            String message = "Agro aid has detected that your plant has Nitrogen deficiency. Below are few tips to increase the nutrient content in the soil.\n" +
                    "1. Create compost out of vegetables, coffee grounds, and other food waste. \n" +
                    "2. Add leftover grass clippings and garden trimmings to your compost.\n" +
                    "3. Plant legume seeds, like peas, alfalfa, and beans that are naturally much higher in nitrogen.\n" +
                    "4. You can also use animal manure. Pick 6 month old (or older) manuremanure produced from poultry or livestock.\n" +
                    "5. As a last resort, use chemical fertilizer for quick results.\n";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Potassium Deficiency")) {
            String message = "Agro aid has detected that your plant has Potassium deficiency. Below are few tips to increase the nutrient content in the soil.\n" +
                    "1. Mix in muriate of potash or sulfate of potash.\n" +
                    "2. Kelp and other types of seaweed are rich in potassium, and quickly release it into soil. You can either mix a few handfuls of dried kelp meal into the soil or by spray it with a liquid seaweed spray.\n" +
                    "3. Add hardwood ash only if you need to increase the soil’s pH. Sprinkle 1 to 2 pounds of ash per 100 square feet (450 to 900 grams per 9 square meters).\n" +
                    "4. Add greensand to your soil. Use about 5 pounds (2.25 kilograms) per 100 square feet (9 square meters) of soil. \n" +
                    "5. You can use Banana peels to increase potassium content. Cut up peels into small pieces and bury them an inch or two (4 or 5 centimeters) in your soil. The peels will take time to rot, so they’ll release potassium more slowly than other amendments. ";
            details.setText(message);
        }
        else if(RecognitionScoreView.a.equals("Phophorous Deficiency")) {
            String message = "Agro aid has detected that your plant has Phosphorous deficiency. Below are few tips to increase the nutrient content in the soil.\n" +
                    "1. Remember, a large percentage of phosphorus in soil is present in chemical compounds that plants are incapable of absorbing.\n" +
                    "2. Common sources of phosphorous are Phosphate, manure and bone meal. \n" +
                    "3. Plants can only get phosphorus from bone meal if the soil pH is below 7.0 (acidic soil).\n" +
                    "4. Maintain the pH of the soil between 6-7 so that the likeliness of phosphorus uptake is increased and the likeliness of phosphorus deficiency is decreased.\n";
            details.setText(message);
        }
        else
        {
            expert.setVisibility(View.GONE);
            details.setText("ERROR");
        }
    }
}

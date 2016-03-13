package com.nHacks.recycleMe;

import android.content.Intent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.clarifai.api.Tag;

/**
 * Created by Juan Zapata on 3/13/2016.
 */
public class Model_Synonyms {

    private static Model_Synonyms singleton_synonym = null;

    private static final String CONTAINER = "container";
    private static final String PAPER = "paper";
    private static final String ORGANIC = "organic";
    private static final String LANDFILL = "landfill";

    private static final String[] CATEGORIES = new String[]{CONTAINER, PAPER, ORGANIC, LANDFILL};

    private static final double THRESHOLD = 0.001;

    private HashSet<String> syn_containers;
    private HashSet<String> syn_paper;
    private HashSet<String> syn_organic;

    //TODO make everything to lowercase for convention

    private Model_Synonyms(){

        this.syn_containers = new HashSet<>(111);
        this.syn_paper = new HashSet<>(35);
        this.syn_organic = new HashSet<>(39);

        this.init_syn_containers();
        this.init_syn_paper();
        this.init_syn_organic();
    }

    private void init_syn_containers(){

        this.syn_containers.add("plastic");
        this.syn_containers.add("elastic");
        this.syn_containers.add("molded");
        this.syn_containers.add("bending");
        this.syn_containers.add("ductile");
        this.syn_containers.add("fictile");
        this.syn_containers.add("formable");
        this.syn_containers.add("moldable");
        this.syn_containers.add("pliable");
        this.syn_containers.add("pliant");
        this.syn_containers.add("resilient");
        this.syn_containers.add("shapeable");
        this.syn_containers.add("supple");
        this.syn_containers.add("workable");

        this.syn_paper.add("glass");
        this.syn_paper.add("mirror");
        this.syn_paper.add("reflector");
        this.syn_paper.add("ceramic");
        this.syn_paper.add("clay");

        this.syn_paper.add("bag");
        this.syn_paper.add("bottle");
        this.syn_paper.add("bowl");
        this.syn_paper.add("bucket");
        this.syn_paper.add("canister");
        this.syn_paper.add("capsule");
        this.syn_paper.add("carton");
        this.syn_paper.add("crate");
        this.syn_paper.add("dish");
        this.syn_paper.add("jar");
        this.syn_paper.add("jug");
        this.syn_paper.add("kettle");
        this.syn_paper.add("package");
        this.syn_paper.add("packet");
        this.syn_paper.add("pail");
        this.syn_paper.add("pot");
        this.syn_paper.add("pouch");
        this.syn_paper.add("sack");
        this.syn_paper.add("storage");
        this.syn_paper.add("tank");
        this.syn_paper.add("tub");
        this.syn_paper.add("utensil");
        this.syn_paper.add("vase");
        this.syn_paper.add("vessel");
        this.syn_paper.add("vial");
        this.syn_paper.add("alembic");
        this.syn_paper.add("beaker");
        this.syn_paper.add("bin");
        this.syn_paper.add("bunker");
        this.syn_paper.add("caisson");
        this.syn_paper.add("canteen");
        this.syn_paper.add("carafe");
        this.syn_paper.add("cask");
        this.syn_paper.add("casket");
        this.syn_paper.add("cauldron");
        this.syn_paper.add("chamber");
        this.syn_paper.add("chest");
        this.syn_paper.add("churn");
        this.syn_paper.add("cistern");
        this.syn_paper.add("cradle");
        this.syn_paper.add("crock");
        this.syn_paper.add("ewer");
        this.syn_paper.add("firkin");
        this.syn_paper.add("flask");
        this.syn_paper.add("hamper");
        this.syn_paper.add("hod");
        this.syn_paper.add("hopper");
        this.syn_paper.add("hutch");
        this.syn_paper.add("jeroboam");
        this.syn_paper.add("magnum");
        this.syn_paper.add("pit");
        this.syn_paper.add("pod");
        this.syn_paper.add("poke");
        this.syn_paper.add("pottery");
        this.syn_paper.add("purse");
        this.syn_paper.add("receptacle");
        this.syn_paper.add("reliquary");
        this.syn_paper.add("repository");
        this.syn_paper.add("sac");
        this.syn_paper.add("scuttle");
        this.syn_paper.add("stein");
        this.syn_paper.add("vat");
        this.syn_paper.add("humidor");

        //=====================================================================
        // Metal?
        //=====================================================================
        this.syn_paper.add("alloy");
        this.syn_paper.add("hardware");
        this.syn_paper.add("ingot");
        this.syn_paper.add("mineral");
        this.syn_paper.add("ore");
        this.syn_paper.add("casting");
        this.syn_paper.add("deposit");
        this.syn_paper.add("foil");
        this.syn_paper.add("load");
        this.syn_paper.add("plate");
        this.syn_paper.add("solder");
        this.syn_paper.add("vein");

    }

    private void init_syn_paper(){

        this.syn_paper.add("paper");
        this.syn_paper.add("cardboard");
        this.syn_paper.add("disposable");
        this.syn_paper.add("insubstantial");
        this.syn_paper.add("paper-thin");
        this.syn_paper.add("papery");
        this.syn_paper.add("wafer-thin");

        this.syn_paper.add("computer paper");
        this.syn_paper.add("white ledger");
        this.syn_paper.add("tab cards");
        this.syn_paper.add("colored ledger");
        this.syn_paper.add("corrugated cardboard");
        this.syn_paper.add("newspaper");

        this.syn_paper.add("lumber");
        this.syn_paper.add("timber");
        this.syn_paper.add("woodland");
        this.syn_paper.add("copse");
        this.syn_paper.add("grove");
        this.syn_paper.add("thicket");
        this.syn_paper.add("timberland");
        this.syn_paper.add("trees");
        this.syn_paper.add("weald");
        this.syn_paper.add("woods");
        this.syn_paper.add("leave");
        this.syn_paper.add("leaves");
    }

    private void init_syn_organic(){

        this.syn_organic.add("organic");
        this.syn_organic.add("food");
        this.syn_organic.add("meal");
        this.syn_organic.add("plate");
        this.syn_organic.add("vegetable");
        this.syn_organic.add("dinner");
        this.syn_organic.add("lunch");
        this.syn_organic.add("breakfast");
        this.syn_organic.add("meat");
        this.syn_organic.add("tomato");
        this.syn_organic.add("salad");
        this.syn_organic.add("cooking");
        this.syn_organic.add("diet");
        this.syn_organic.add("pepper");
        this.syn_organic.add("tasty");
        this.syn_organic.add("fruit");
        this.syn_organic.add("berry");
        this.syn_organic.add("crop");
        this.syn_organic.add("grain");
        this.syn_organic.add("nut");
        this.syn_organic.add("produce");
        this.syn_organic.add("product");
        this.syn_organic.add("drupe");
        this.syn_organic.add("harvest");
        this.syn_organic.add("yield");
        this.syn_organic.add("biological");

        this.syn_organic.add("dessert");
        this.syn_organic.add("cake");
        this.syn_organic.add("candy");
        this.syn_organic.add("confection");
        this.syn_organic.add("cookie");
        this.syn_organic.add("frozen dessert");
        this.syn_organic.add("frozen treat");
        this.syn_organic.add("fruit");
        this.syn_organic.add("ice cream");
        this.syn_organic.add("last course");
        this.syn_organic.add("pastry");
        this.syn_organic.add("pie");
        this.syn_organic.add("pudding");
        this.syn_organic.add("sweet");
        this.syn_organic.add("sweet course");
        this.syn_organic.add("tart");

    }

    private static Model_Synonyms getSingleton(){

        if (singleton_synonym == null)
            singleton_synonym = new Model_Synonyms();

        return singleton_synonym;
    }

    private static String getCategory(String testing_tag){

        if(null == testing_tag || testing_tag.length() <= 0)
            return LANDFILL;

        if (getSingleton().syn_containers.contains(testing_tag))
            return CONTAINER;
        else if (getSingleton().syn_organic.contains(testing_tag))
            return ORGANIC;
        else if (getSingleton().syn_paper.contains(testing_tag))
            return PAPER;
        else
            return LANDFILL;
    }

    public static String getCategory(List<Tag> collection_tag){

        if(null == collection_tag || collection_tag.size() <= 0)
            return LANDFILL;

        int[] tally_values = new int[CATEGORIES.length];


        // relate each tag to a catgagory
        for (Tag curr_tag : collection_tag) {

            String curr_category = Model_Synonyms.getCategory(curr_tag.getName());

            for (int i = 0 ; i <CATEGORIES.length ; i++)
                if (CATEGORIES[i].equals(curr_category)) {
                    tally_values[i]++;
                    break; //move on to the next foreach item
                }
        }


        // Run simple analytics

        int max_index = CATEGORIES.length - 1; //worst case scenario we will return "landfill"
        double curr_max = -1;

        // Dont test with "landfill" because that should only be used if none of the tags are above the threshold
        for (int i = 0 ; i < CATEGORIES.length - 1 ; i++){

            double testing_max = 1.0*tally_values[i]/collection_tag.size();

            //update the max and index if required
            if (testing_max > curr_max && testing_max >= THRESHOLD){
                curr_max = testing_max;
                max_index = i;
            }
        }

        return CATEGORIES[max_index];
    }
}

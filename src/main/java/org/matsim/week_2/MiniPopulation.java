package org.matsim.week_2;

import org.matsim.api.core.v01.population.Population;
import org.matsim.api.core.v01.population.PopulationFactory;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.population.PopulationUtils;

public class MiniPopulation {

    public static void main(String[] args) {
        Config config = ConfigUtils.createConfig();

        Population emptyPopulation = PopulationUtils.createPopulation(config);

        PopulationFactory popFactory = emptyPopulation.getFactory();



    }

    public void popGen(){
        for (int i = 1; i <= 500 ; i++){
            String indent = new String("Person_" + i);
        }
    }
}

package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;

public class Report implements Executable {
@Inject
    private Repository repository;

    public Report(){}

    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
       return this.repository.getStatistics();
    }
}

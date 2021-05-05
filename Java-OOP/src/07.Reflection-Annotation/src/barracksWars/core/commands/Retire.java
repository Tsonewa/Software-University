package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire implements Executable {
    @Inject
    private Repository repository;
    @Inject
    private String[] data;

    public Retire(){}

    public Retire(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {

        this.repository.removeUnit(this.data[1]);

        return this.data[1] + " retired!";
    }
}

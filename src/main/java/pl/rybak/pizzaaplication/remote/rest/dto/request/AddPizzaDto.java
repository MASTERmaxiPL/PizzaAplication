package pl.rybak.pizzaaplication.remote.rest.dto.request;

import java.util.List;

public class AddPizzaDto {
    private String name;
    private List<AddSizeDto> addSizes;

    public AddPizzaDto(){
    }

    public AddPizzaDto(String name, List<AddSizeDto> addSizes) {
        this.name = name;
        this.addSizes = addSizes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<AddSizeDto> getSizes() {
        return addSizes;
    }

    public void setSizes(List<AddSizeDto> sizes) {
        this.addSizes = addSizes;
    }
}

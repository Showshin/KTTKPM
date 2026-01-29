package Adapter;

public class AdapterDemo {
    public static void main(String[] args) {

        XMLService xmlService = new XMLService();
        JSONService jsonService = new XMLtoJSONAdapter(xmlService);

        jsonService.processJSON("{\"name\":\"John\", \"age\":30}");
    }
}


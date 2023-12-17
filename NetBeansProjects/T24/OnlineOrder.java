import java.util.ArrayList;
import java.util.List;

public class OnlineOrder implements Order {

    private String deliveryAddress;

    private List<Item> items;

    public OnlineOrder(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public boolean addItem(Item item) {
        try {
            if (items.size() != 0) {
                throw new RuntimeException("Error:" + item.getName() + " already has an existing order.");
            } else {
                items.add(item);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return  false;
    }

    @Override
    public boolean removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return items.remove(item);
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        List<Item> itemsToRemove = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                itemsToRemove.add(item);
                count++;
            }
        }
        items.removeAll(itemsToRemove);
        return count;
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public int getCount(String itemName) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String[] getOrderedItems() {
        return new String[0];
    }

    @Override
    public Item[] getSortedItems() {
        return new Item[0];
    }

    @Override
    public Item[] getItems() {
        return items.toArray(new Item[0]);
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getTableNumber() {
        return deliveryAddress; // Используем адрес в качестве "номера стола" для online заказа
    }
}

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) throws NotRegisteredException {

        if (findByName(player.getName()) == null) {
            registeredPlayers.add(player);
        } else {
            throw new NotRegisteredException("Игрок с таким именем уже зарегистрирован");
        }
    }

    public Player findByName(String name) {

        for (int i = 0; i < registeredPlayers.size(); i++) {
            if (registeredPlayers.get(i).getName() == name) {
                return registeredPlayers.get(i);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        Player first = findByName(playerName1);
        Player second = findByName(playerName2);

        if (first == null & second == null) {
            throw new NotRegisteredException("Игроки" + first + " и " + second + "не зарегистрированы");
        } else if (first == null) {
            throw new NotRegisteredException("Игрок" + first + " не зарегистрирован");
        } else if (second == null) {
            throw new NotRegisteredException("Игрок" + second + " не зарегистрирован");
        } else {

            if (first.getStrength() == second.getStrength()) {
                return 0;
            } else if (first.getStrength() > second.getStrength()) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}

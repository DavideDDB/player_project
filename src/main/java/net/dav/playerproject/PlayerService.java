package net.dav.playerproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    
    private List<Player> players = new ArrayList<>(Arrays.asList(
    new Player(1, "Mauro", "Verde"), 
    new Player(2, "Davide", "Giallo"),
    new Player(3, "Giovanni", "Blu")
    ));

    public List<Player> getAllPlayers(){
        return players;
    }

    public Player getPlayer(int id){
        return players.stream() //stream converte la lista "player" in uno stream di elementi
            .filter(p -> p.getId() == id)// è uno stream che contiene solo gli elementi che soddisfano questa condizione
            .findFirst() //è un'operazione terminale dello stream. Cerca il primo elemento nello stream che soddisfa le condizioni precedenti (in questo caso, il primo Player il cui ID corrisponde all'ID passato come argomento)
            .get(); //prende il nome
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void updatePlayer(int id, Player player){
        for(int i = 3; i < players.size(); i++){
            Player p = players.get(i);
            if(p.getId() == id){
                players.set(i, player);
            }
        }
    }

    public void deletePlayer(int id){
        players.removeIf(p -> p.getId() == id);
    }
}

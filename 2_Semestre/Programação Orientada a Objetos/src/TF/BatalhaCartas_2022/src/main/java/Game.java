import java.util.*;

public class Game extends Observable{
    private static Game game = new Game();
    private int ptsJ1,ptsJ2;
    private CardDeck deckJ1,deckJ2;
    private int player;
    private int jogadas;
    
    public static Game getInstance(){
        return(game);
    }
    
    private Game(){
        ptsJ1 = 0;
        ptsJ2 = 0;
        deckJ1 = new CardDeck();
        deckJ2 = new CardDeck();
        player = 1;
        jogadas = CardDeck.NCARDS;
    }
    
    private void nextPlayer(){
        player++;
        if (player == 4){
            player = 1;
        }
    }
        
    public int getPtsJ1(){
        return(ptsJ1);
    }

    public int getPtsJ2(){
        return(ptsJ2);
    }
    
    public CardDeck getDeckJ1(){
        return(deckJ1);
    }
    
    public CardDeck getDeckJ2(){
        return(deckJ2);
    }
    
    public void play(CardDeck deckAcionado){
        GameEvent gameEvent = null;

        if (player == 3){
                gameEvent = new GameEvent(GameEvent.Target.GWIN,GameEvent.Action.MUSTCLEAN,"");
                setChanged();
                notifyObservers((Object)gameEvent);
                return;
        }        
        if (deckAcionado == deckJ1){
            if (player != 1){
                gameEvent = new GameEvent(GameEvent.Target.GWIN,GameEvent.Action.INVPLAY,"2");
                setChanged();
                notifyObservers((Object)gameEvent);
            }else{
                // Vira a carta
                deckJ1.getSelectedCard().flip();
                // Proximo jogador
                nextPlayer();
            }
        }else if (deckAcionado == deckJ2){
            if (player != 2){
                gameEvent = new GameEvent(GameEvent.Target.GWIN,GameEvent.Action.INVPLAY,"2");
                setChanged();
                notifyObservers((Object)gameEvent);
            }else{
                // Vira a carta
                deckJ2.getSelectedCard().flip();
                // Verifica quem ganhou a rodada
                if (deckJ1.getSelectedCard().getValue() > deckJ2.getSelectedCard().getValue()){
                    ptsJ1++;
                }else if (deckJ1.getSelectedCard().getValue() < deckJ2.getSelectedCard().getValue()){
                    ptsJ2++;
                }
                setChanged();
                notifyObservers((Object)gameEvent);
                // Próximo jogador
                nextPlayer();
            }
        }          
    }

    // Acionada pelo botao de limpar    
    public void removeSelected(){
        GameEvent gameEvent = null;
        
        if (player != 3){
            return;
        }
        jogadas--;
        if (jogadas == 0){
            gameEvent = new GameEvent(GameEvent.Target.GWIN,GameEvent.Action.ENDGAME,"");
            setChanged();
            notifyObservers((Object)gameEvent);
            //return;
        }
        deckJ1.removeSel();
        deckJ2.removeSel();
        nextPlayer();
    }
}
package com.interview.chuteAndLadder;


import java.util.*;

/**
 * @author Bing ZHANG
 * @created 19/01/2022
 */
public class Game {

    private Square[] board;
    private List<SquareEvent> chuteEventList;
    private List<SquareEvent> ladderEventList;
    private List<Player> playerList;
    private Spinner spinner;


    public Game(int chuteAmount, int ladderAmount, List<Player> playerList, Spinner spinner) {
        board = new Square[101];
        for(int i = 0; i < 101; i++) {
            board[i] = new Square(i);
        }
        System.out.println("-----------Boarder is created successfully, size 10 x 10");
        Set<Integer> fromSet = new HashSet<>();
        chuteEventList = new ArrayList<>();
        ladderEventList = new ArrayList<>();
        for(int i = 0; i < chuteAmount; i++) {
            chuteEventList.add(new SquareEvent("CHUTE",100, fromSet));
        }
        for(int i = 0; i < ladderAmount; i++) {
            ladderEventList.add(new SquareEvent("LADDER",100, fromSet));
        }

        for(SquareEvent event : chuteEventList) {
            board[event.getFromSpot()].setSquareEvent(event);
        }
        for(SquareEvent event : ladderEventList) {
            board[event.getFromSpot()].setSquareEvent(event);
        }
        this.playerList = playerList;
        this.spinner = spinner;
    }

    public Square[] getBoard() {
        return board;
    }

    public List<SquareEvent> getChuteEventList() {
        return chuteEventList;
    }

    public List<SquareEvent> getLadderEventList() {
        return ladderEventList;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }


    public static void main(String[] args) {

        List<Player> playerList = Arrays.asList(Player.builder()
                .nickName("player1")
                .position(0)
                .build(), Player.builder()
                .nickName("player2")
                .position(0)
                .build(), Player.builder()
                .nickName("player3")
                .position(0)
                .build(), Player.builder()
                .nickName("player4")
                .position(0)
                .build());
        Spinner spinner = new Spinner(6);

        Game game = new Game(10, 10, playerList, spinner);
        boolean gameOn = true;
        while(gameOn) {
            for(Player player: game.getPlayerList()) {
                int moves = spinner.getSpinner();
                int currentSpot = player.getPosition();
                player.setPosition(player.getPosition() + moves);
                System.out.println("Player : " + player.getNickName() + " at " + currentSpot + " spins " + moves + " -----> move to position " + player.getPosition());
                if(player.getPosition() > 100) {
                    player.setPosition(player.getPosition() - moves);
                    System.out.println("Player : " + player.getNickName() + " return back to spot " + player.getPosition());

                }
                if(player.getPosition() == 100) {
                    gameOn = false;
                    System.out.println("Winner for this round is " + player.getNickName());
                    return;
                }
                if(game.getBoard()[player.getPosition()].getSquareEvent()!= null) {
                    SquareEvent event = game.getBoard()[player.getPosition()].getSquareEvent();
                    player.setPosition(event.getToSpot());
                    System.out.println("Event " + event.getName() + " encounter, move to position ---->" + player.getPosition());
                }
            }
        }
    }

}

package fr.amoussa.SixTakes.Solo.Model;

import java.util.*;
import fr.amoussa.SixTakes.Solo.Controller.FoldListener;
import fr.amoussa.SixTakes.Solo.View.Card;

public class Round extends TimerTask {

  public Card c;
  public int time;
  public Game g;

  Round(int t, Game g) {
    this.time = t;
    this.g = g;
    System.out.println("Commencement nouveau round");

  }

  @Override
  public void run() {

    if (!Game.isPaused()) {
      this.g.getView().renderChrono("Il vous reste " + this.time + " secondes pour jouer");
      if (this.time == 0) {
        this.g.getView().renderChrono("");
        this.g.getAllPlays();
        cancel();
      }
      this.time--;

    }

  }
}

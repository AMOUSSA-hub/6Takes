package fr.amoussa.SixTakes.Solo.Model;

import java.util.*;
import fr.amoussa.SixTakes.Solo.Controller.FoldListener;
import fr.amoussa.SixTakes.Solo.View.Card;

public class FoldSelection extends TimerTask {

  public Card c;
  public int time;
  public Game g;

  FoldSelection(int t, Game g) {
    this.time = t;
    this.g = g;
    FoldListener.setSelectable(true);

  }

  @Override
  public void run() {

    // if (!Game.isPaused()) {
    this.g.getView().renderChrono("<html>Choisissez une pile <br>" + this.time + "</html>");
    if (this.time == 0) {
      this.g.getView().renderChrono("");
      FoldListener.setSelectable(false);
      cancel();
    }

    this.time--;
    // }

  }
}

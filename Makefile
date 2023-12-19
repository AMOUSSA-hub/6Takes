# COMMANDES #
JAVAC = javac
# note $$ to get a single shell $
JAVAC_OPTIONS = -d build  -sourcepath src   -encoding UTF-8 -implicit:none
JAVA = java
JAVA_OPTIONS_W = -cp build 
JAVA_OPTIONS = -cp build 
JAR = jar
EXEC_JAR = ${JAVA} -jar
SUP = rm -rf

# CHEMINS RELATIFS
SRC = src/fr/amoussa/SixTakes
BUILD = build/fr/amoussa/SixTakes
DOC = doc/fr/amoussa/SixTakes
BUILD_WINDOWS = "build/fr/amoussa/SixTakes/"
# CHOIX NOMS
JAR_FILE =  6Takes.jar

# AUTRE BUTS
doc :
	javadoc -d doc -encoding UTF-8  src/fr/amoussa/SixTakes/Solo/Controller/*.java src/fr/amoussa/SixTakes/Solo/View/*.java src/fr/amoussa/SixTakes/Solo/Model/*.java src/fr/amoussa/SixTakes/Utils/*.java src\fr\amoussa\SixTakes\App.java  src\fr\amoussa\SixTakes\Multijoueur/View/*.java 



# BUT PAR DEFAUT #
run : ${BUILD}/App.class
	${JAVA} ${JAVA_OPTIONS} fr.amoussa.SixTakes.App

run_W :${BUILD}/App.class
	${JAVA} ${JAVA_OPTIONS_W} fr.amoussa.SixTakes.App

jar:${JAR_FILE}
	${EXEC_JAR} ${JAR_FILE}

server: ${BUILD}/Server/GameServer.class
	${JAVA} ${JAVA_OPTIONS} fr.amoussa.SixTakes.Server.GameServer 2023

client: ${BUILD}/Server/Client.class
	${JAVA} ${JAVA_OPTIONS} fr.amoussa.SixTakes.Server.Client 172.31.252.86 2023 Machine_local 

# POUR WINDOWS#
clean_W : 
	rd /s /q ${BUILD_WINDOWS}

clean_jar_W:
	del 6Takes.jar

#POUR LINUX 
clean : 
	rm -r build/*

clean_jar:
	rm 6Takes.jar
	
# REGLES DE DEPENDANCE #

${BUILD}/App.class:  ${SRC}/App.java \
	${BUILD}/Solo/View/Acceuil.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/App.java

# CLASSES VIEW#

${BUILD}/Solo/View/Acceuil.class:  ${SRC}/Solo/View/Accueil.java \
	${BUILD}/Solo/Controller/AcceuilListener.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/Accueil.java

${BUILD}/Solo/View/GameFen.class:  ${SRC}/Solo/View/GameFen.java \
	${BUILD}/Solo/View/FormNumberPlayer.class \
	${BUILD}/Solo/View/GameBoard.class \
	${BUILD}/Solo/Model/Game.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/GameFen.java

${BUILD}/Solo/View/FormNumberPlayer.class: ${SRC}/Solo/View/FormNumberPlayer.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/FormNumberPlayer.java

${BUILD}/Solo/View/GameBoard.class: ${SRC}/Solo/View/GameBoard.java \
	${BUILD}/Solo/View/Card.class \
	${BUILD}/Solo/Controller/DeckListener.class \
	${BUILD}/Solo/View/Fold.class \
	${BUILD}/Solo/View/MyJLabel.class \
	${BUILD}/Solo/View/PauseFen.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/GameBoard.java

${BUILD}/Solo/View/Card.class: ${SRC}/Solo/View/Card.java \
	${BUILD}/Utils/Icone.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/Card.java	


${BUILD}/Solo/View/Fold.class:  ${SRC}/Solo/View/Fold.java \
	${BUILD}/Solo/Controller/FoldListener.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/Fold.java

${BUILD}/Solo/View/MyJLabel.class:  ${SRC}/Solo/View/MyJLabel.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/MyJLabel.java

${BUILD}/Solo/View/ResultFrame.class:  ${SRC}/Solo/View/ResultFrame.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/ResultFrame.java

${BUILD}/Multijoueur/View/Lobby.class:  ${SRC}/Multijoueur/View/Lobby.java \
	${BUILD}/Server/Client.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Multijoueur/View/Lobby.java

${BUILD}/Solo/View/PauseFen.class:  ${SRC}/Solo/View/PauseFen.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/View/PauseFen.java


# CLASSES CONTROLLER#

${BUILD}/Solo/Controller/AcceuilListener.class:  ${SRC}/Solo/Controller/AccueilListener.java \
	${BUILD}/Solo/View/GameFen.class \
	${BUILD}/Multijoueur/View/Lobby.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Controller/AccueilListener.java


${BUILD}/Solo/Controller/DeckListener.class: ${SRC}/Solo/Controller/DeckListener.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Controller/DeckListener.java


${BUILD}/Solo/Controller/FoldListener.class: ${SRC}/Solo/Controller/FoldListener.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Controller/FoldListener.java
# CLASSES MODEL#

${BUILD}/Solo/Model/Game.class:  ${SRC}/Solo/Model/Game.java \
	${BUILD}/Solo/Model/Player.class \
	${BUILD}/Solo/Model/FoldModel.class \
	${BUILD}/Solo/View/ResultFrame.class \
	${BUILD}/Solo/Model/Round.class \
	${BUILD}/Solo/Model/FoldSelection.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Model/Game.java

${BUILD}/Solo/Model/FoldModel.class:  ${SRC}/Solo/Model/FoldModel.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Model/FoldModel.java

${BUILD}/Solo/Model/Round.class:  ${SRC}/Solo/Model/Round.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Model/Round.java	

${BUILD}/Solo/Model/FoldSelection.class:  ${SRC}/Solo/Model/FoldSelection.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Model/FoldSelection.java


${BUILD}/Solo/Model/Player.class:  ${SRC}/Solo/Model/Player.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Solo/Model/Player.java

# CLASSES UTILS#



${BUILD}/Utils/Icone.class:  ${SRC}/Utils/Icone.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Utils/Icone.java


# SERVER #

${BUILD}/Server/Client.class:  ${SRC}/Server/Client.java \
	${BUILD}/Server/FormattedMessage.class	
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Server/Client.java


${BUILD}/Server/GameServer.class:  ${SRC}/Server/GameServer.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Server/GameServer.java


${BUILD}/Server/FormattedMessage.class:  ${SRC}/Server/FormattedMessage.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Server/FormattedMessage.java




# ## JARS ##

 ${JAR_FILE} : ${BUILD}/App.class
	${JAR} cvfe ${JAR_FILE}  fr.amoussa.SixTakes.App -C build .  -C res .




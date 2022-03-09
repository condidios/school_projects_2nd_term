import java.util.*;
import java.io.*;

public class Main {
	// All the methods I have used during the coding procees
	public static boolean writerChecker(ArrayList<Writer> list1,String ID) {
		int checker = 0;
		String[] splitted = ID.split(",");
		for (String k : splitted) {
			for (Person i : list1) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean directorChecker(ArrayList<Director> list1,String ID) {
		int checker = 0;
		String[] splitted = ID.split(",");
		for (String k : splitted) {
			for (Person i : list1) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else {return false;}
	}
	public static boolean performerChecker(ArrayList<Actor> list1,ArrayList<ChildActor> list2, ArrayList<StuntPerformer> list3,String ID) {
		int checker =0;
		String[] splitted = ID.split(",");
		for (String k : splitted) {
			for (Person i : list1) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
			for (Person i : list2) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
			for (Person i : list3) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else {return false;}
	}
	public static boolean shortFilmChecker(ArrayList<ShortFilm> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Film i : list1) {
				if (i.getFilmId().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean featureFilmChecker(ArrayList<FeatureFilm> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Film i : list1) {
				if (i.getFilmId().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean isAlreadyExist(ArrayList<Film> list1,String ID){
		for (Film i: list1){
			if (i.filmId.equals(ID)){
				return true;
			}
		}
		return false;
	}
	public static boolean documentaryFilmChecker(ArrayList<Documentary> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Film i : list1) {
				if (i.getFilmId().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean tvSeriesChecker(ArrayList<TvSeries> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Film i : list1) {
				if (i.getFilmId().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean filmChecker(ArrayList<Film> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Film i : list1) {
				if (i.getFilmId().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean userChecker(ArrayList<User> list1,String ID) {
		String[] splitted = ID.split(",");
		int checker = 0;
		for (String k : splitted) {
			for (Person i : list1) {
				if (i.getID().equals(k)) {
					checker++;
				}
			}
		}
		if (checker == splitted.length){
			return true;
		}
		else{return false;}
	}
	public static boolean isThereTheUser(ArrayList<User> list1, String ID){
		for (User i: list1){
			if (i.ID.equals(ID)) {
				return true;
			}
		}
		return false;
	}
	public static ArrayList findDirector (String list1 , ArrayList<Director> directorObject){
		ArrayList<Director> selected = new ArrayList<>();
		try {
			String[] listSplitted = list1.split(",");
			for	(Director i : directorObject){
				for (String k : listSplitted){
					if (k.equals(i.ID)){
						selected.add(i);
						break;
					}
				}
			}
		}
		catch (Exception e){
			//
		}
		return selected;
	}
	public static ArrayList findActor (String list1 , ArrayList<Actor> actorObject){
		ArrayList<Actor> selected = new ArrayList<>();
		try {
			String[] listSplitted = list1.split(",");
			for	(Actor i : actorObject){
				for (String k : listSplitted){
					if (k.equals(i.ID)){
						selected.add(i);
						break;
					}
				}
			}
		}
		catch (Exception e){
			//
		}
		return selected;
	}
	public static ArrayList findWriter (String list1 , ArrayList<Writer> writerObject){
		ArrayList<Writer> selected = new ArrayList<>();
		try {
			String[] listSplitted = list1.split(",");
			for	(Writer i : writerObject){
				for (String k : listSplitted){
					if (k.equals(i.ID)){
						selected.add(i);
						break;
					}
				}
			}
		}
		catch (Exception e){
			//
		}
		return selected;
	}
	public static ArrayList findChildActor (String list1 , ArrayList<ChildActor> childActorObject){
		ArrayList<ChildActor> selected = new ArrayList<>();
		try {
			String[] listSplitted = list1.split(",");
			for	(ChildActor i : childActorObject){
				for (String k : listSplitted){
					if (k.equals(i.ID)){
						selected.add(i);
						break;
					}
				}
			}
		}
		catch (Exception e){
			//
		}
		return selected;
	}
	public static ArrayList findStuntPerformer (String list1 , ArrayList<StuntPerformer> stuntPerformerObject){
		ArrayList<StuntPerformer> selected = new ArrayList<>();
		try {
			String[] listSplitted = list1.split(",");
			for	(StuntPerformer i : stuntPerformerObject){
				for (String k : listSplitted){
					if (k.equals(i.ID)){
						selected.add(i);
						break;
					}
				}
			}
		}
		catch (Exception e){
			//
		}
		return selected;
	}
	public static ArrayList mergeArray(ArrayList<Actor> actorList, ArrayList<ChildActor> childActorList, ArrayList<StuntPerformer> stuntList){
		ArrayList<Performer> selected = new ArrayList<>();
		for(Actor i : actorList){
			selected.add(i);
		}
		for (ChildActor i: childActorList){
			selected.add(i);
		}
		for (StuntPerformer i: stuntList){
			selected.add(i);
		}
		return selected;
	}

    public static void main(String[] args) throws IOException {
	    File commands = new File(args[2]);
	    File films = new File(args[1]);
	    File people = new File(args[0]);
	    FileReader frCommands = new FileReader(commands);
	    FileReader frFilms = new FileReader(films);
	    FileReader frPeople = new FileReader(people);
	    BufferedReader brCommands = new BufferedReader(frCommands);
	    BufferedReader brPeople = new BufferedReader(frPeople);
	    BufferedReader brFilms = new BufferedReader(frFilms);
	    BufferedWriter brOutput = new BufferedWriter(new FileWriter(args[3]));
	    String line;
	    ArrayList<User> userObject = new ArrayList<User>();
	    ArrayList<Actor> actorObject = new ArrayList<Actor>();
	    ArrayList<ChildActor> childActorObject = new ArrayList<ChildActor>();
	    ArrayList<Director> directorObject = new ArrayList<Director>();
	    ArrayList<Documentary> documentaryObject = new ArrayList<>();
	    ArrayList<FeatureFilm> featureFilmObject = new ArrayList<>();
	    ArrayList<ShortFilm> shortFilmObject = new ArrayList<>();
	    ArrayList<StuntPerformer> stuntPerformerObject = new ArrayList<>();
	    ArrayList<TvSeries> tvSeriesObject = new ArrayList<>();
	    ArrayList<Writer> writerObject = new ArrayList<>();
	    ArrayList<Film> filmObject = new ArrayList<>();
	    String finalText ="";

	    while ((line = brPeople.readLine()) != null){
	    	String[] peopleArray = line.split("\t");
	    	if (peopleArray[0].equals("Actor:")){
	    		Actor actor1 = new Actor(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1],peopleArray[5]);
	    		actorObject.add(actor1);
			}
	    	else if (peopleArray[0].equals("Director:")){
	    		Director director1 = new Director(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1],peopleArray[5]);
	    		directorObject.add(director1);
			}
	    	else if (peopleArray[0].equals("Writer:")){
				Writer writer1 = new Writer(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1],peopleArray[5]);
				writerObject.add(writer1);
			}
	    	else if (peopleArray[0].equals("ChildActor:")){
				ChildActor childActor1 = new ChildActor(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1],peopleArray[5]);
				childActorObject.add(childActor1);
			}
	    	else if (peopleArray[0].equals("StuntPerformer:")){
				StuntPerformer stuntPerformer1 = new StuntPerformer(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1],peopleArray[5],peopleArray[6]);
				stuntPerformerObject.add(stuntPerformer1);
			}
	    	else if (peopleArray[0].equals("User:")){
	    		User user1 = new User(peopleArray[2],peopleArray[3],peopleArray[4],peopleArray[1]);
	    		userObject.add(user1);
			}
		}
	    while ((line = brFilms.readLine()) != null){
	        String[] filmsArray = line.split("\t");
			try{
	        	if (filmsArray[0].equals("FeatureFilm:")){

					FeatureFilm featureFilm1 = new FeatureFilm(filmsArray[1],filmsArray[2],filmsArray[3],Integer.parseInt(filmsArray[5]),filmsArray[6],findDirector(filmsArray[4],directorObject),mergeArray(findActor(filmsArray[7],actorObject),findChildActor(filmsArray[7],childActorObject),findStuntPerformer(filmsArray[7],stuntPerformerObject)), filmsArray[9],filmsArray[11],filmsArray[8].replace(" ","").replace(",",", "),findWriter(filmsArray[10],writerObject));
					featureFilmObject.add(featureFilm1);
					filmObject.add(featureFilm1);
				}
	        	if (filmsArray[0].equals("ShortFilm:") && Integer.parseInt(filmsArray[5]) <= 40){
	        		if (Integer.parseInt(filmsArray[5]) <= 40) {
						ShortFilm shortFilm1 = new ShortFilm(filmsArray[1], filmsArray[2], filmsArray[3], Integer.parseInt(filmsArray[5]), filmsArray[6], findDirector(filmsArray[4], directorObject), mergeArray(findActor(filmsArray[7], actorObject), findChildActor(filmsArray[7], childActorObject), findStuntPerformer(filmsArray[7], stuntPerformerObject)), filmsArray[9], filmsArray[8].replace(" ", "").replace(",", ", "), findWriter(filmsArray[10], writerObject));
						shortFilmObject.add(shortFilm1);
						filmObject.add(shortFilm1);
					}
					else {
						finalText += "Short films can not be longer than 40 minutes";
					}
				}
	        	if (filmsArray[0].equals("Documentary:")){

	        		Documentary documentary1 = new Documentary(filmsArray[1],filmsArray[2],filmsArray[3],Integer.parseInt(filmsArray[5]),filmsArray[6],findDirector(filmsArray[4],directorObject),mergeArray(findActor(filmsArray[7],actorObject),findChildActor(filmsArray[7],childActorObject),findStuntPerformer(filmsArray[7],stuntPerformerObject)),filmsArray[8]);
	        		documentaryObject.add(documentary1);
	        		filmObject.add(documentary1);
				}
	        	else if	(filmsArray[0].equals("TVSeries:")){

	        		TvSeries tvSeries1 = new TvSeries(filmsArray[1],filmsArray[2],filmsArray[3],Integer.parseInt(filmsArray[5]),filmsArray[6],findDirector(filmsArray[4],directorObject),mergeArray(findActor(filmsArray[7],actorObject),findChildActor(filmsArray[7],childActorObject),findStuntPerformer(filmsArray[7],stuntPerformerObject)),filmsArray[10],filmsArray[11],filmsArray[12],filmsArray[13],filmsArray[8].replace(" ","").replace(",",", "),findWriter(filmsArray[9],writerObject));
	        		tvSeriesObject.add(tvSeries1);
	        		filmObject.add(tvSeries1);
				}

			}
			catch (Exception e){
				//
			}
        }
	    while ((line = brCommands.readLine()) != null){
	    	String[] commandArray = line.split("\t");
	    	line.trim();
	    	finalText += line + "\n\n";
	    	String text = "";
	    	if (commandArray[0].equals("ADD") && commandArray[1].equals("FEATUREFILM")){
				FeatureFilm featureFilm1 = new FeatureFilm(commandArray[2],commandArray[3],commandArray[4],Integer.parseInt(commandArray[6]),commandArray[7],findDirector(commandArray[5],directorObject),mergeArray(findActor(commandArray[8],actorObject),findChildActor(commandArray[8],childActorObject),findStuntPerformer(commandArray[8],stuntPerformerObject)), commandArray[10],commandArray[12],commandArray[9].replace(" ","").replace(",",", "),findWriter(commandArray[11],writerObject));
				if (!featureFilmObject.contains(featureFilm1) && writerChecker(writerObject, commandArray[11]) && directorChecker(directorObject,commandArray[5]) && performerChecker(actorObject,childActorObject,stuntPerformerObject,commandArray[8]) && !isAlreadyExist(filmObject,commandArray[2]) ){
					featureFilmObject.add(featureFilm1);
					filmObject.add(featureFilm1);
					text += "FeatureFilm added successfully\nFilm ID: " + commandArray[2] + "\nFilm title: " + commandArray[3] + "\n\n";
				}
				else{
					//Command failed hatası
					text += "Command Failed\nFilm ID: " + commandArray[2] + "\nFilm title: " + commandArray[3] + "\n\n";
				}
				finalText += text;
			}
	    	else if (commandArray[0].equals("VIEWFILM")){
	    		String ID = "";
	    		for (Film i : filmObject){
	    			if (commandArray[1].equals(i.filmId)){
	    				ID = commandArray[1];
					}
				}
	    		if (ID != "") {
					if (featureFilmChecker(featureFilmObject, ID)) {
						for (FeatureFilm i : featureFilmObject) {
							if (ID.equals(i.filmId)) {
								text += i.toString() + "\n";
							}
						}
					} else if (shortFilmChecker(shortFilmObject, ID)) {
						for (ShortFilm i : shortFilmObject) {
							if (ID.equals(i.filmId)) {
								text += i.toString() + "\n";
							}
						}
					} else if (documentaryFilmChecker(documentaryObject, ID)) {
						for (Documentary i : documentaryObject) {
							if (ID.equals(i.filmId)) {
								text += i.toString() + "\n";
							}
						}
					} else if (tvSeriesChecker(tvSeriesObject, ID)) {
						for (TvSeries i : tvSeriesObject) {
							if (ID.equals(i.filmId)) {
								text += i.toString() + "\n";
							}
						}
					}
				}
	    		else{text += "Command Failed\nFilm ID: " + commandArray[1] + "\n\n";}
	    		finalText += text;
			}
	    	else if (commandArray[0].equals("RATE")){
	    		boolean checker = true;
	    		if ((featureFilmChecker(featureFilmObject,commandArray[2]) || shortFilmChecker(shortFilmObject,commandArray[2]) || documentaryFilmChecker(documentaryObject,commandArray[2]) || tvSeriesChecker(tvSeriesObject,commandArray[2]))&& isThereTheUser(userObject,commandArray[1])){
					for (User i: userObject) {
						if (commandArray[1].equals(i.ID)) {
							if (!i.rateChecker(i.rate,commandArray[2])){
								i.rateSys(commandArray[3], commandArray[2]);
								break;
							}
							else{
								text += "This film was earlier rated\n\n";
								checker = false;
								break;
							}
						}

					}
					if (checker){
						outer:
						for (FeatureFilm i : featureFilmObject) {
							for (ShortFilm k : shortFilmObject) {
								for (Documentary l : documentaryObject) {
									for (TvSeries o : tvSeriesObject) {
										if (commandArray[2].equals(i.filmId)) {
											i.rateChange(Integer.parseInt(commandArray[3]), commandArray[1]);
											text += "Film rated successfully\nFilm type: FeatureFilm\nFilm title: " + i.title + "\n\n";
											break outer;
										} else if (commandArray[2].equals(k.filmId)) {
											k.rateChange(Integer.parseInt(commandArray[3]), commandArray[1]);
											text += "Film rated successfully\nFilm type: ShortFilm\nFilm title: " + k.title + "\n\n";
											break outer;
										} else if (commandArray[2].equals(l.filmId)) {
											l.rateChange(Integer.parseInt(commandArray[3]), commandArray[1]);
											text += "Film rated successfully\nFilm type: Documentary\nFilm title: " + l.title + "\n\n";
											break outer;
										} else if (commandArray[2].equals(o.filmId)) {
											o.rateChange(Integer.parseInt(commandArray[3]), commandArray[1]);
											text += "Film rated successfully\nFilm type: TVSeries\nFilm title: " + o.title + "\n\n";
											break outer;
										}
									}
								}
							}
						}
					}
	    		}
	    		else{
					text += "Command Failed\nUser ID: " + commandArray[1] + "\nFilm ID: " + commandArray[2] + "\n\n";
				}
	    		finalText += text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("USER") && commandArray[3].equals("RATES")){
	    		if (isThereTheUser(userObject,commandArray[2])){
					ArrayList<String> Ids = new ArrayList<>();
					ArrayList<String> Rating = new ArrayList<>();
					for (User i: userObject){
						if (commandArray[2].equals(i.getID())){
							for (String[] k: i.rate) {
								Ids.add(k[1]);
								Rating.add(k[0]);
							}
						}
					}
					if (Ids.size() != 0){
						for (int k = 0; k < Ids.size(); k++) {
							for (Film i : filmObject) {
								if (i.getFilmId().equals(Ids.get(k))) {
									text += i.title + ": " + Rating.get(k)+"\n";
								}
							}
						}

					}
					else {
						text += "There is not any ratings so far\n";
					}
	    		}
	    		else{
	    			text += "Command Failed\nUser ID: " + commandArray[2] + "\n";
				}
	    		finalText += text+"\n";
			}
	    	else if (commandArray[0].equals("EDIT") && commandArray[1].equals("RATE")) {
				if (userChecker(userObject, commandArray[2]) && filmChecker(filmObject, commandArray[3])){
					boolean checker = true;
					outer:
					for (User i : userObject) {
						if (i.rateChecker(i.rate, commandArray[3]) && i.ID.equals(commandArray[2])) {
							for (Film k : filmObject) {
								if (i.ID.equals(commandArray[2]) && k.getFilmId().equals(commandArray[3])) {
									i.rateChange(commandArray[4], commandArray[3]);
									k.editRate(commandArray[4], commandArray[2]);
									text += "New ratings done successfully\nFilm title: " + k.title + "\nYour rating: " + commandArray[4]+"\n\n";
									checker = false;
									break outer;

								}
							}
						}
					}
					if (checker){
						text += "Command Failed\nUser ID: " + commandArray[2] + "\nFilm ID: " + commandArray[3] + "\n\n";
					}
				}
				else{
					text += "Command Failed\nUser ID: " + commandArray[2] + "\nFilm ID: " + commandArray[3] + "\n\n";
				}
				finalText += text;
			}
	    	else if (commandArray[0].equals("REMOVE") && commandArray[1].equals("RATE")){
				if (userChecker(userObject, commandArray[2]) && filmChecker(filmObject, commandArray[3])){
					boolean checker = true;
					outer:
					for (User i: userObject){
						if (i.rateChecker(i.rate,commandArray[3])){
							for (Film k: filmObject){
								if (i.ID.equals(commandArray[2]) && k.getFilmId().equals(commandArray[3])){
									i.rateDelete(commandArray[3]);
									k.deleteRate(commandArray[2]);
									text += "Your film rating was removed successfully\nFilm title: " + k.title + "\n\n";
									checker = false;
									break outer;
								}
							}
						}
					}
					if (checker){
						text += "Command Failed\nUser ID: " + commandArray[2] + "\nFilm ID: " + commandArray[3] + "\n\n";
					}
				}
				else{
					text += "Command Failed\nUser ID: " + commandArray[2] + "\nFilm ID: " + commandArray[3] + "\n\n";
				}
				finalText += text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("FILM") && commandArray[2].equals("SERIES")){
	    		if (tvSeriesObject.size() != 0){
	    			for (TvSeries i: tvSeriesObject){
	    				text += i.title + " (" + i.startDate.substring(6)+"-"+i.endDate.substring(6)+")\n"+
								i.seasons + " seasons and " + i.episodes + " episodes\n\n";
					}
				}
	    		else{
	    			text += "No result\n\n";
				}
	    		finalText += text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("FILMS") && commandArray[2].equals("BY") && commandArray[3].equals("COUNTRY")){
	    		ArrayList<Film> tempList = new ArrayList<>();
	    		for (Film i: filmObject){
	    			if (i.country.equals(commandArray[4])){
	    				tempList.add(i);
					}
				}
	    		if (tempList.size() != 0){
	    			for (Film i: tempList){
	    				text += "Film title: "+i.title +"\n"+
								i.runtime + " min\n"+
								"Language: "+i.language+"\n\n";
					}
				}
	    		else{
	    			text += "No result\n\n";
				}
	    		finalText += text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("FEATUREFILMS") && commandArray[2].equals("BEFORE")){
	    		ArrayList<FeatureFilm> temp = new ArrayList<>();
				for (FeatureFilm i: featureFilmObject){
					if (Integer.parseInt(commandArray[3]) > Integer.parseInt(i.releaseDate.substring(6))){
						temp.add(i);
					}
				}
				if (temp.size() != 0){
					for (FeatureFilm i: temp){
						text += "Film title: "+i.title+" ("+i.releaseDate.substring(6)+")\n"+
								i.runtime + " min\n"+
								"Language: " + i.language+"\n\n";
					}
				}
				else{
					text += "No result\n\n";
				}
				finalText+= text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("FEATUREFILMS") && commandArray[2].equals("AFTER")){
				ArrayList<FeatureFilm> temp = new ArrayList<>();
				for (FeatureFilm i: featureFilmObject){
					if (Integer.parseInt(commandArray[3]) <= Integer.parseInt(i.releaseDate.substring(6))){
						temp.add(i);
					}
				}
				if (temp.size() != 0){
					for (FeatureFilm i: temp){
						text += "Film title: "+i.title+" ("+i.releaseDate.substring(6)+")\n"+
								i.runtime + " min\n"+
								"Language: " + i.language+"\n\n";
					}
				}
				else{
					text += "No result\n\n";
				}
				finalText += text;
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("FILMS") && commandArray[2].equals("BY") && commandArray[3].equals("RATE") && commandArray[4].equals("DEGREE")){
	    		ArrayList<FeatureFilm> sortedFeature = new ArrayList<>();
	    		ArrayList<ShortFilm> sortedShort = new ArrayList<>();
	    		ArrayList<Documentary> sortedDocumentary = new ArrayList<>();
	    		ArrayList<TvSeries> sortedTvSeries = new ArrayList<>();
	    		text += "FeatureFilm:\n";
	    		if (featureFilmObject.size() != 0) {
					sortedFeature = (ArrayList<FeatureFilm>) featureFilmObject.clone();
					sortedFeature.sort(Comparator.comparing(FeatureFilm::getRating));
					Collections.reverse(sortedFeature);
					for (FeatureFilm i : sortedFeature) {
						text += i.title + " (" + i.releaseDate.substring(6) + ") Ratings: "+i.getRating()+"/10 from " + i.ratings.size() + " users\n";
					}
				}
	    		else{
	    			text+="No result\n\n";
				}
	    		text += "\nShortFilm:\n";
	    		if (shortFilmObject.size()!=0){
	    			sortedShort = (ArrayList<ShortFilm>) shortFilmObject.clone();
	    			sortedShort.sort(Comparator.comparing(ShortFilm::getRating));
	    			Collections.reverse(sortedShort);
	    			for (ShortFilm i : sortedShort){
	    				text += i.title + " (" + i.releaseDate.substring(6) + ") Ratings: "+i.getRating()+"/10 from " + i.ratings.size() + " users\n";
					}
				}
	    		else{
	    			text +="No result\n\n";
				}
	    		text += "\nDocumentary:\n";
	    		if (directorObject.size() != 0){
	    			sortedDocumentary = (ArrayList<Documentary>) documentaryObject.clone();
	    			sortedDocumentary.sort(Comparator.comparing(Documentary::getRating));
	    			Collections.reverse(sortedDocumentary);
	    			for (Documentary i: sortedDocumentary){
	    				text += i.title + " (" + i.releaseDate.substring(6) + ") Ratings: "+i.getRating()+"/10 from " + i.ratings.size() + " users\n";
					}
				}
	    		else{
	    			text += "No result\n\n";
				}
	    		text += "\nTVSeries:\n";
	    		if (tvSeriesObject.size() != 0){
	    			sortedTvSeries = (ArrayList<TvSeries>) tvSeriesObject.clone();
	    			sortedTvSeries.sort(Comparator.comparing(TvSeries::getRating));
	    			Collections.reverse(sortedTvSeries);
	    			for (TvSeries i: sortedTvSeries){
	    				text+= i.title + " (" + i.startDate.substring(6) + "-" +i.endDate.substring(6) + ") Ratings: " + i.getRating() + "/10 from " + i.ratings.size() + " users\n";
					}
				}
	    		else{
	    			text += "No result\n\n";
				}
	    		finalText += text + "\n";
			}
	    	else if (commandArray[0].equals("LIST") && commandArray[1].equals("ARTISTS") && commandArray[2].equals("FROM")){
	    		ArrayList<Director> directorSelected = new ArrayList<>();
	    		ArrayList<Writer> writerSelected = new ArrayList<>();
	    		ArrayList<Actor> actorSelected = new ArrayList<>();
	    		ArrayList<ChildActor> childSelected = new ArrayList<>();
	    		ArrayList<StuntPerformer> stuntSelected = new ArrayList<>();
	    		text += "Directors:\n";
	    		for (Director i: directorObject){
	    			if (i.country.equals(commandArray[3])){
	    				directorSelected.add(i);
					}
				}
	    		if (directorSelected.size() != 0){
	    			for (Director i:directorSelected){
	    				text += i.name + " " + i.surname + " " + i.agent + "\n";
					}
				}
	    		else{
	    			text += "No result\n\n";
				}
	    		text += "\nWriters:\n";
	    		for (Writer i: writerObject){
	    			if (i.country.equals(commandArray[3])){
	    				writerSelected.add(i);
					}
				}
	    		if (writerSelected.size() != 0){
	    			for (Writer i: writerSelected){
	    				text += i.name + " " + i.surname + " " + i.writingType + "\n";
					}
				}
	    		else{
	    			text += "No result\n";
				}
				text += "\nActors:\n";
				for (Actor i: actorObject){
					if (i.country.equals(commandArray[3])){
						actorSelected.add(i);
					}
				}
				if (actorSelected.size() != 0){
					for (Actor i: actorSelected){
						text += i.name + " " + i.surname + " "  + i.height + " cm\n";
					}
				}
				else{
					text += "No result\n";
				}
	    		text += "\nChildActors:\n";
	    		for (ChildActor i: childActorObject){
	    			if (i.country.equals(commandArray[3])){
	    				childSelected.add(i);
					}
				}
	    		if (childSelected.size() != 0){
	    			for (ChildActor i: childSelected){
	    				text += i.name + " " + i.surname + " "  + i.age + "\n";
					}
				}
	    		else{
	    			text += "No result\n";
				}
				text += "\nStuntPerformers:\n";
				for (StuntPerformer i: stuntPerformerObject){
					if (i.country.equals(commandArray[3])){
						stuntSelected.add(i);
					}
				}
				if (stuntSelected.size() != 0){
					for (StuntPerformer i: stuntSelected){
						text += i.name + " " + i.surname + " "  + i.height + " cm\n";
					}
				}
				else{
					text += "No result\n";
				}
				finalText += text + "\n";
			}
	    	finalText += "-----------------------------------------------------------------------------------------------------\n";
	    }
	    brOutput.write(finalText);
	    brOutput.flush();
    }
}
import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * list all items used for-each
     */
    
    public void listAllFile(){
        int posicion = 1;
        for(String filename : files){
            System.out.println(posicion+ " . " +filename);
            posicion = posicion +1;
        }
    
    }
    
    /**
     * imprime los archivos con una cadena dada
     */
    public void listMatching(String searchString)
    {
        boolean seHanEncontradoResultados = false;//if secundario no hay coincidencia.
        //bucle de busquedaen la lista files, para los elementos que contienen la cadena especificada.
        for (String filename : files)
        {
            if(filename.contains(searchString))
            {
                System.out.println(filename);
                seHanEncontradoResultados=true; //se ha encontrado resultado, no se ejecuta la opcion booleana
            }
        }
        
        if (!seHanEncontradoResultados)
        {
            System.out.println("error no se han encontrado archivos el texto");
        }
    }
    
    /**
     * reproduce primeros segundos canciones de un archivo
     */
    public void playSamplesArtist(String artist)
    {
        
        for(String filename : files)
        {
            if(filename.contains(artist))
            {
                //metodo de reproduccion en musicplay
                player.playSample(filename);
            }
        }
        
    }
    
    public int findFirst(String searchString)
    {
        int index = 0;
        boolean found = false;
        int sizeArray = files.size();
        while(!found && index < sizeArray)
        {
            String fileName = files.get(index);
            if(fileName.contains(searchString))
            {
                found = true;
            }
            else
            {
               index++;
            }
        }
        if(!found)
        {
             index = -1;
        }
        return index;
    }
}




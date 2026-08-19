abstract class MediaFile {
    protected String fileName;

    public MediaFile(String fileName) {
        this.fileName = fileName;
    }

    public abstract void showInfo();
}

interface Playable {
    void play();
}

interface Compressible {
    void compress();
}

class ImageFile extends MediaFile implements Compressible {
    public ImageFile(String fileName) {
        super(fileName);
    }

    @Override
    public void showInfo() {
        System.out.println("圖片檔案：" + fileName);
    }

    @Override
    public void compress() {
        System.out.println(fileName + "：執行圖片壓縮");
    }
}

class AudioFile extends MediaFile implements Playable, Compressible {
    public AudioFile(String fileName) {
        super(fileName);
    }

    @Override
    public void showInfo() {
        System.out.println("音訊檔案：" + fileName);
    }

    @Override
    public void play() {
        System.out.println(fileName + "：播放音訊");
    }

    @Override
    public void compress() {
        System.out.println(fileName + "：執行音訊壓縮");
    }
}

class VideoFile extends MediaFile implements Playable, Compressible {
    public VideoFile(String fileName) {
        super(fileName);
    }

    @Override
    public void showInfo() {
        System.out.println("影片檔案：" + fileName);
    }

    @Override
    public void play() {
        System.out.println(fileName + "：播放影片");
    }

    @Override
    public void compress() {
        System.out.println(fileName + "：執行影片壓縮");
    }
}

public class MediaProcessingSystem {
    public static void main(String[] args) {
        MediaFile[] files = {
            new ImageFile("photo.jpg"),
            new AudioFile("music.mp3"),
            new VideoFile("movie.mp4")
        };

        for (MediaFile file : files) {
            file.showInfo();

            if (file instanceof Playable playable) {
                playable.play();
            }

            if (file instanceof Compressible compressible) {
                compressible.compress();
            }

            System.out.println();
        }
    }
}
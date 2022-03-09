import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {
    private String id, name = "", university = "", department = "", eMail = "", article1, article2, article3, article4, article5;

    public String getArticle1() {
        return article1;
    }

    public void setArticle1(String article1) {
        this.article1 = article1;
    }

    public String getArticle2() {
        return article2;
    }

    public void setArticle2(String article2) {
        this.article2 = article2;
    }

    public String getArticle3() {
        return article3;
    }

    public void setArticle3(String article3) {
        this.article3 = article3;
    }

    public String getArticle4() {
        return article4;
    }

    public void setArticle4(String article4) {
        this.article4 = article4;
    }

    public String getArticle5() {
        return article5;
    }

    public void setArticle5(String article5) {
        this.article5 = article5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void sortArticles(){
        List<String> sortList = new ArrayList<>();
        if (article1 != null){
            sortList.add(article1);
        }
        if (article2 != null){
            sortList.add(article2);
        }
        if (article3 != null){
            sortList.add(article3);
        }
        if (article4 != null){
            sortList.add(article4);
        }
        if (article5 != null){
            sortList.add(article5);
        }
        Collections.sort(sortList);
        try {
            this.article1 = sortList.get(0);
            this.article2 = sortList.get(1);
            this.article3 = sortList.get(2);
            this.article4 = sortList.get(3);
            this.article5 = sortList.get(4);
        }
        catch (Exception e) {
            //
        }

    }
}
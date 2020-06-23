package com.example.zad5_fragmenty;

public class ProgrammingLanguage {

    private String name;
    private String description;

    public static final ProgrammingLanguage[] languages = {
            new ProgrammingLanguage("C", "Imperatywny, strukturalny język programowania wysokiego poziomu stworzony na początku lat siedemdziesiątych XX w. przez Dennisa Ritchiego do programowania systemów operacyjnych i innych zadań niskiego poziomu."),
            new ProgrammingLanguage("C++", "Jest to język programowania ogólnego przeznaczenia. Daje możliwości programowania strukturalnego i obiektowego. Wspiera abstrakcję danych i programowanie uogólnione. Stworzony został przez Bjarne Stroustrupa a jego pierwsza wersja pojawiła się w roku 1979."),
            new ProgrammingLanguage("Java", "Współbieżny, oparty na klasach, obiektowy język programowania ogólnego zastosowania[5]. Został stworzony przez grupę roboczą pod kierunkiem Jamesa Goslinga z firmy Sun Microsystems."),
            new ProgrammingLanguage("Python", "Język programowania wysokiego poziomu ogólnego przeznaczenia[4], o rozbudowanym pakiecie bibliotek standardowych[5], którego ideą przewodnią jest czytelność i klarowność kodu źródłowego. Jego składnia cechuje się przejrzystością i zwięzłością."),
            new ProgrammingLanguage("C#", "Obiektowy język programowania zaprojektowany w latach 1998-2001 przez zespół pod kierunkiem Andersa Hejlsberga dla firmy Microsoft."),
    };

    private ProgrammingLanguage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

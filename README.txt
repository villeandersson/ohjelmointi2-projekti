SERVLETIT
ArtistListServlet.java
doGet-metodi hakee tietokannasta sivulle tulostettavan artistilistan, doPost-metodi lisää tietokantaan uuden artistin.

AlbumServlet.java
doGet-metodi hakee tietokannasta sivulle tulostettavan listan parametrina välitetyn artistin albumeista.


DAO-LUOKAT
ArtistDao.java
Hakee tietokannasta artistien tiedot.

AlbumDao.java
Hakee parametrina välitetyn artistin albumien tiedot.


JSP-SIVUT
artistList.jsp
Näyttää sivulla listan artisteista.

albumList.jsp
Näyttää sivulla listan albumeista.
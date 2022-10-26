Feature: US011 web tablasundaki istenen sutunu yazdirma

  Scenario:TC16 kullanici sutun basligi ile liste alabilmeli

    Given kullanici "guruUrl" anasayfasinda
    And kullanici 3 saniye bekler
    And "Prev Close (Rs)" sutunundaki tum degerleri yazdirir
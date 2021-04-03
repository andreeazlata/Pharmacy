package tests;

import domain.Medicine;
import repository.IRepository;
import repository.InMemoryRepository;
import repository.RepositoryException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @org.junit.jupiter.api.Test
    void createShouldValidateTheIdAndAddTheObject() throws Exception {
        // setup (arrange)
        IRepository<Medicine> inMemoryRepository = new InMemoryRepository<>();
        Medicine medicine1 = new Medicine(1, "aaa", "aa1", 21, true, 89);
        Medicine medicine2 = new Medicine(2, "bbb", "aa1", 25, false, 25);
        Medicine medicine3 = new Medicine(1, "ccc", "aa1", 76, true, 69);

        // act
        inMemoryRepository.create(medicine1);

        // assert
        assertEquals(1, inMemoryRepository.read().size(), "Dupa adaugarea unui medicament, read().size() != 1!");
        assertEquals(medicine1.getIdEntity(), inMemoryRepository.read().get(0).getIdEntity());

        // act
        inMemoryRepository.create(medicine2);

        // assert
        assertEquals(2, inMemoryRepository.read().size(), "Dupa adaugarea a 2 medicamente, read().size() != 2!");

        // TODO: see assertThrows()
        try {
            // act
            inMemoryRepository.create(medicine3);

            // assert
            fail("Adaugarea unei prajituri cu id existent nu da exceptie!");
        } catch (RepositoryException ex) {

            // assert
            assertEquals(2, inMemoryRepository.read().size(), "S-a adaugat un medicament cu id existent!");
        }
    }
         @org.junit.jupiter.api.Test
        void readOneShouldCorrectlyReturnMedicine() throws Exception {
            IRepository<Medicine> inMemoryRepository = new InMemoryRepository<>();
            List<Medicine> medicines = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Medicine medicine = new Medicine(i,"alabala","portocala",58,true,69);
                medicines.add(medicine);
            }

            for (Medicine prajitura : medicines) {
                inMemoryRepository.create(prajitura);
            }

            for (int i = 0; i < 20; ++i) {
                Medicine foundById = inMemoryRepository.readOne(i);
                assertEquals(i, foundById.getIdEntity());
            }

            assertNull(inMemoryRepository.readOne(100));
        }

    @org.junit.jupiter.api.Test
    void deleteShouldValidateTheIdAndRemoveTheObject() throws Exception {
        IRepository<Medicine> inMemoryRepository = new InMemoryRepository<>();
        List<Medicine> medicines = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Medicine medicine = new Medicine(i,"ffff","gggg",45,true,68);
            medicines.add(medicine);
        }

        for (Medicine medicine : medicines) {
            inMemoryRepository.create(medicine);
        }

        for (int i = 0; i < 20; ++i) {
            inMemoryRepository.delete(i);
            Medicine foundById = inMemoryRepository.readOne(i);
            assertNull(foundById);
            assertEquals(20 - i - 1, inMemoryRepository.read().size());
        }

        try {
            inMemoryRepository.delete(5);
            fail("Stergerea unui medicament cu id existent nu da exceptie!");
        } catch (Exception ex) {
            assertEquals(0, inMemoryRepository.read().size(), "Exista medicamente nesterse!");
        }
    }


    @org.junit.jupiter.api.Test
    void update() {
    }

}
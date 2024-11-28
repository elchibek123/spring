package java15.services;

import java15.repositories.CrudRepo;
import java15.repositories.LaptopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepo laptopRepo;
    @Qualifier("laptopRepoImpl")
    private final CrudRepo crudRepo;
}

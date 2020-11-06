package co.mydiary;

import co.mydiary.dtos.Baby.BabyAllDTO;
import co.mydiary.dtos.Baby.BabyInfoDTO;
import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.repositories.Baby.BabyRepository;
import co.mydiary.repositories.Baby.entities.BabyAllEntity;
import co.mydiary.repositories.Baby.entities.BabyInfoEntity;
import co.mydiary.repositories.Baby.entities.BabyGrowthChartEntity;
import co.mydiary.services.BabyService;
import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class AppServiceTest {

    @Mock
    private BabyRepository repository;

    @Mock
    private MapperFacade mapper;

    @InjectMocks
    private BabyService systemUnderTest;

    @Test
    public void getAllBabyInfo_ScenarioA() {

        //arrange
        List<BabyInfoEntity> databaseEntties = new ArrayList<>();
        BabyInfoEntity babyA = new BabyInfoEntity();
        babyA.setName("A");
        databaseEntties.add(babyA);

        doReturn(databaseEntties).when(repository).getAlBabyInfo();

        List<BabyInfoDTO> mapperList = new ArrayList<>();
        BabyInfoDTO babyInfoDTOA = new BabyInfoDTO();
        babyInfoDTOA.setName("A");
        mapperList.add(babyInfoDTOA);

        doReturn(mapperList).when(mapper).mapAsList(databaseEntties, BabyInfoDTO.class);


        //act
        List<BabyInfoDTO> actual = systemUnderTest.getAllBabyInfo();

        //assert
        Assert.assertThat(actual.size(), is(1));
        Assert.assertThat(actual.get(0).getName(), is(equalTo("A")));

        //verify
        verify(repository, times(1)).getAlBabyInfo();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getAllBabyGrowthInfo_ScenarioA() {
        //arrange
        List<BabyGrowthChartEntity> databaseEntity = new ArrayList<>();
        BabyGrowthChartEntity babyA = new BabyGrowthChartEntity();
        babyA.setName("A");
        databaseEntity.add(babyA);

        doReturn(databaseEntity).when(repository).getAllBabyGrowthInfo();

        List<BabyGrowthChartDTO> mapperList = new ArrayList<>();
        BabyGrowthChartDTO babyDTOA = new BabyGrowthChartDTO();
        babyDTOA.setName("A");
        mapperList.add(babyDTOA);

        doReturn(mapperList).when(mapper).mapAsList(databaseEntity, BabyGrowthChartDTO.class);

        //act
        List<BabyGrowthChartDTO> actual = systemUnderTest.getAllBabyGrowthInfo();

        //assert
        Assert.assertThat(actual.size(), is(1));
        Assert.assertThat(actual.get(0).getName(), is(equalTo("A")));

        //verify
        verify(repository, times(1)).getAllBabyGrowthInfo();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void getAllByName_ScenarioA() {

        //arrange
        List<BabyAllEntity> databaseEntity = new ArrayList<>();
        BabyAllEntity babyA = new BabyAllEntity();
        babyA.setName("A");
        databaseEntity.add(babyA);

        doReturn(databaseEntity).when(repository).getAlByName("A");

        List<BabyAllDTO> mapperList = new ArrayList<>();
        BabyAllDTO babyDTOA = new BabyAllDTO();
        babyDTOA.setName("A");
        mapperList.add(babyDTOA);

        doReturn(mapperList).when(mapper).mapAsList(databaseEntity, BabyAllDTO.class);

        //act
        List<BabyAllDTO> actual = systemUnderTest.getAllByName("A");

        //assert
        Assert.assertThat(actual.size(), is(1));
        Assert.assertThat(actual.get(0).getName(), is(equalTo("A")));

        //verify
        verify(repository, times(1)).getAlByName("A");
        verifyNoMoreInteractions(repository);

    }

    @Test
    public void addNewEntry_ScenarioA() {
        //arrange
        BabyInfoEntity entity = new BabyInfoEntity();
        entity.setId(1);
        entity.setName("A");

        doNothing().when(repository).addNewEntry(entity);

        BabyInfoDTO baby = new BabyInfoDTO();
        baby.setId(1);
        baby.setName("A");


        systemUnderTest.addNewEntry(baby);
    }

}

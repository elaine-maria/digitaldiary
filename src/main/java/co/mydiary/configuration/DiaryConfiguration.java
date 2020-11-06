package co.mydiary.configuration;

import co.mydiary.dtos.Baby.BabyInfoDTO;
import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.dtos.Wedding.ClothingDTO;
import co.mydiary.dtos.Wedding.EventDTO;
import co.mydiary.dtos.Wedding.VendorDTO;
import co.mydiary.repositories.Baby.entities.BabyInfoEntity;
import co.mydiary.repositories.Baby.entities.BabyGrowthChartEntity;
import co.mydiary.repositories.Wedding.entities.ClothingEntity;
import co.mydiary.repositories.Wedding.entities.EventEntity;
import co.mydiary.repositories.Wedding.entities.VendorEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiaryConfiguration {

    @Bean
    public MapperFactory mapperFactory() {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .dumpStateOnException(false)
                .useBuiltinConverters(true)
                .build();

        mapperFactory.classMap(BabyInfoDTO.class, BabyInfoEntity.class)
                .mapNulls(true)
                .byDefault()
                .register();

        mapperFactory.classMap(BabyGrowthChartDTO.class, BabyGrowthChartEntity.class)
                .mapNulls(true)
                .byDefault()
                .register();

        mapperFactory.classMap(EventDTO.class, EventEntity.class)
                .mapNulls(true)
                .byDefault()
                .register();

        mapperFactory.classMap(VendorDTO.class, VendorEntity.class)
                .mapNulls(true)
                .byDefault()
                .register();

        mapperFactory.classMap(ClothingDTO.class, ClothingEntity.class)
                .mapNulls(true)
                .byDefault()
                .register();

        return mapperFactory;
    }

        @Bean
        public MapperFacade mapper(MapperFactory mapperFactory) {
            return mapperFactory.getMapperFacade();
        }

}

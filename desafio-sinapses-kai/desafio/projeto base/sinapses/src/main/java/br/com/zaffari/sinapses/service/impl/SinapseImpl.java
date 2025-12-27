// package br.com.zaffari.sinapses.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import br.com.zaffari.sinapses.domain.Sinapse;
// import br.com.zaffari.sinapses.repository.SinapseRepository;
// import br.com.zaffari.sinapses.service.SinapseService;

// import java.util.List;

// @Service
// public class SinapseImpl implements SinapseService{

//     @Autowired
//     private SinapseRepository sinapseRepository;

//     /*public SinapseImpl(SinapseRepository sinapseRepository) {
//         this.sinapseRepository = sinapseRepository;
//     }*/

//     /* CORRIGIDO */
//     @Override
//     // public Sinapse create(Sinapse sinapse) {
//         return sinapseRepository.save(sinapse);
//     }

//     @Override
//     public List<Sinapse> list() {
//         Sort sort = Sort.by("categoria").ascending().and(
//             Sort.by("dataDeEstudo").descending().and(
//                 Sort.by("palavrasChave").ascending()
//             )
//         );
//         return sinapseRepository.findAll(sort);
//     }

//     @Override 
//     public List<Sinapse> update(Sinapse sinapse) {
//         sinapseRepository.save(sinapse);
//         return list();
//     }

//     @Override 
//     public List<Sinapse> delete(Sinapse id) {
//         sinapseRepository.delete(id);
//         return list();
//     }
// }
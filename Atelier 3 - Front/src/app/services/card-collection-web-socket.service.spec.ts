import { TestBed } from '@angular/core/testing';

import { CardCollectionWebSocketService } from './card-collection-web-socket.service';

describe('CardCollectionWebSocketService', () => {
  let service: CardCollectionWebSocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardCollectionWebSocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

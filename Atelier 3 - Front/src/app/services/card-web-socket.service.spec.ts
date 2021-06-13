import { TestBed } from '@angular/core/testing';

import { CardWebSocketService } from './card-web-socket.service';

describe('CardWebSocketService', () => {
  let service: CardWebSocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardWebSocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
